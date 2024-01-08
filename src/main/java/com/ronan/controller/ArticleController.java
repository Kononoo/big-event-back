package com.ronan.controller;

import com.ronan.entity.Article;
import com.ronan.entity.PageBean;
import com.ronan.entity.R;
import com.ronan.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * ClassName: ArticleController
 * Package: com.ronan.controller
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 19:57
 * @Version: v1.0
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public R<String> add(@RequestBody Article article) {
        log.info("添加文章:{}", article.toString());
        articleService.add(article);
        return R.success("添加文章成功");
    }

    @GetMapping
    public R<PageBean<Article>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pageBean = articleService.list(currentPage, pageSize, categoryId, state);
        return R.success(pageBean);
    }

}
