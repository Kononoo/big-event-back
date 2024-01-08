package com.ronan.mapper;

import com.ronan.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * ClassName: UserMapper
 * Package: com.ronan.mapper
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 15:00
 * @Version: v1.0
 */
@Mapper
public interface UserMapper {
    @Select("select * from bg_user where username = #{username}")
    User selectUserByUsername(String username);

    @Insert("insert into bg_user(username, password, create_time, update_time)" +
            "values (#{username}, #{password}, now(), now())")
    void addUser(@Param("username") String username, @Param("password") String password);

    @Select("select * from bg_user where id = #{id}")
    User selectById(Integer id);

    @Update("update bg_user set nickname = #{nickname}, email = #{email}, update_time = #{updateTime} where id = #{id};")
    void update(User user);

    @Update("update bg_user set user_pic = #{avatarUrl} where id = #{id}")
    void updateAvatar(String avatarUrl, Integer id);
}
