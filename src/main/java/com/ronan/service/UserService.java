package com.ronan.service;

import com.ronan.entity.User;

/**
 * ClassName: UserService
 * Package: com.ronan.service
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 15:00
 * @Version: v1.0
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 注册用户
     * @param username
     * @param password
     */
    void register(String username, String password);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 更新用户头像
     * @param avatarUrl
     */
    void updateAvatar(String avatarUrl);

    /**
     * 更新米密码
     *
     * @param id
     * @param newPwd
     */
    void updatePwd(Integer id, String newPwd);
}
