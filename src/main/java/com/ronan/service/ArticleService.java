package com.ronan.service;

import com.ronan.entity.Article;
import com.ronan.entity.PageBean;

/**
 * ClassName: ArticleService
 * Package: com.ronan.service
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:46
 * @Version: v1.0
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     */
    void add(Article article);

    /**
     * 条件分页查询
     * @param currentPage
     * @param pageSize
     * @param categoryId
     * @param state
     * @return
     */
    PageBean<Article> list(Integer currentPage, Integer pageSize, Integer categoryId, String state);

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Article getById(Integer id);

    /**
     * 根据id更新文章
     * @param article
     */
    void update(Article article);

    /**
     * 根据id删除文章
     * @param id
     */
    void delete(Integer id);
}
