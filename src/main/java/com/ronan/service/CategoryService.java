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

    List<Category> list();
}
