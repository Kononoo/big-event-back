package com.ronan.mapper;

import com.ronan.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * ClassName: CategoryMapper
 * Package: com.ronan.mapper
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:46
 * @Version: v1.0
 */
@Mapper
public interface CategoryMapper {
    @Insert("insert into bg_category(category_name, category_alias, create_user, create_time, update_time)" +
            "values (#{categoryName}, #{categoryAlias}, #{createUser}, now(), now())")
    void insert(Category category);

    @Select("select * from bg_category where create_user = #{id}")
    List<Category> list(Integer id);

    @Select("select * from bg_category where id = #{id}")
    Category selectById(Integer id);

    @Update("update bg_category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = now() where id = #{id}")
    void updateById(Category category);

    @Delete("delete * from bg_category where id = #{id}")
    void deleteById(Integer id);
}
