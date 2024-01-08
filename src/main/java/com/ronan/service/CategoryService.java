package com.ronan.service;

import com.ronan.entity.Category;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.ronan.service
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 19:02
 * @Version: v1.0
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param category
     */
    void add(Category category);

    /**
     * 获取文章分类列表
     * @return
     */
    List<Category> list();

    /**
     * 根据id获取文章
     * @param id
     * @return
     */
    Category findById(Integer id);

    /**
     * 更新文章分类
     * @param category
     */
    void update(Category category);

    /**
     * 根据id删除文章分类
     * @param id
     */
    void delete(Integer id);
}
