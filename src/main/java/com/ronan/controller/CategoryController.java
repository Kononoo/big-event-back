package com.ronan.controller;

import com.ronan.entity.Category;
import com.ronan.entity.R;
import com.ronan.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.ronan.controller
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 19:01
 * @Version: v1.0
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> addCategory(@RequestBody @Validated(Category.Add.class) Category category) {
        log.info("添加分类：{}", category.toString());
        categoryService.add(category);
        return R.success("添加成功");
//    "categoryName":"人文",
//    "categoryAlias":"rw"
    }

    @GetMapping
    public R<List<Category>> list() {
        List<Category> categoryList = categoryService.list();
        return R.success(categoryList);
    }

    @GetMapping("/detail")
    public R<Category> getDetail(@RequestParam("id") Integer id) {
        Category category = categoryService.findById(id);
        return R.success(category);
    }

    @PutMapping
    public R<String> update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return R.success("更新成功");
    }

    @DeleteMapping
    public R<String> delete(@RequestParam("id") Integer id) {
        categoryService.delete(id);
        return R.success("删除成功");
    }
}
