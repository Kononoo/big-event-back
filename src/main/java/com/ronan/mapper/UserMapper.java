package com.ronan.mapper;

import com.ronan.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * ClassName: UserMapper
 * Package: com.ronan.mapper
 * Description:
 *  发现多个参数时似乎不加@param来指定参数名也能获取参数，了解到可以通过反射获取参数名的，
 *  不过反射效率一般比较低，建议都加上@param，有@param指定参数后就不会通过反射获取了
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

    @Update("update bg_user set user_pic = #{avatarUrl}, update_time = now() where id = #{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl, @Param("id") Integer id);

    @Update("update bg_user set password = #{password} where id = #{id}")
    void updatePwd(@Param("password") String password, @Param("id") Integer id);
}
