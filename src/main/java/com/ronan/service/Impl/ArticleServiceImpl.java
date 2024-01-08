package com.ronan.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ronan.config.ThreadLocalContext;
import com.ronan.entity.Article;
import com.ronan.entity.PageBean;
import com.ronan.mapper.ArticleMapper;
import com.ronan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: ArticleServiceImpl
 * Package: com.ronan.service.Impl
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:47
 * @Version: v1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        HashMap<String, Object> map = ThreadLocalContext.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.insect(article);
    }

    @Override
    public PageBean<Article> list(Integer currentPage, Integer pageSize, Integer categoryId, String state) {
        // 创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();
        // 分页查询
        PageHelper.startPage(currentPage, pageSize);

        HashMap<String, Object> map = ThreadLocalContext.get();
        Integer userId = (Integer) map.get("id");
        // 使用插件
        List<Article> articleList = articleMapper.list(userId, categoryId, state);
        Page<Article> articlePage = (Page<Article>) articleList;

        pageBean.setTotal(articlePage.getTotal());
        pageBean.setItems(articlePage.getResult());
        return pageBean;
//        // 自己来
//        int begin = (currentPage - 1) * pageSize;
//        List<Article> articleList = articleMapper.list(begin, pageSize, userId, categoryId, state);

    }

    @Override
    public Article getById(Integer id) {
        Article article =  articleMapper.selectById(id);
        return article;
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.deleteById(id);
    }
}
