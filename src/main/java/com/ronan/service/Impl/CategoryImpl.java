package com.ronan.service.Impl;

import com.ronan.config.ThreadLocalContext;
import com.ronan.entity.Category;
import com.ronan.mapper.CategoryMapper;
import com.ronan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName: CategoryImpl
 * Package: com.ronan.service.Impl
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 19:02
 * @Version: v1.0
 */
@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        HashMap<String, Object> map = ThreadLocalContext.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        categoryMapper.insert(category);
    }

    @Override
    public List<Category> list() {
        HashMap<String, Object> map = ThreadLocalContext.get();
        Integer id = (Integer) map.get("id");
        List<Category> categoryList =  categoryMapper.list(id);
        return categoryList;
    }

    @Override
    public Category findById(Integer id) {
        Category category = categoryMapper.selectById(id);
        return category;
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteById(id);
    }
}
