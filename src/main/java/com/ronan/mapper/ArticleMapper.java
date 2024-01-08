package com.ronan.mapper;

import com.ronan.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ArticleMapper
 * Package: com.ronan.mapper
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:46
 * @Version: v1.0
 */
@Mapper
public interface ArticleMapper {
    @Insert("insert into bg_article(title,content,cover_img,state,category_id,create_user,create_time,update_time)" +
            "values (#{title}, #{context}, #{coverImg}, #{categoryId}, #{createUser}, now(), now())")
    void insect(Article article);

    List<Article> list(Integer userId, Integer categoryId, String state);

    @Select("select * from bg_article where id = #{id}")
    Article selectById(Integer id);

    @Update("update bg_article set title = #{title}, content = #{content}, cover_img = #{coverImg}, state = #{state}, " +
            "category_id = #{categoryId}, update_time = #{updateTime} where id = #{id}")
    void update(Article article);

    @Delete("delele * from bg_article where id = #{id}")
    void deleteById(Integer id);
}
