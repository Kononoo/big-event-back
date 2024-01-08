package com.ronan.service.Impl;

import com.ronan.config.ThreadLocalContext;
import com.ronan.entity.User;
import com.ronan.mapper.UserMapper;
import com.ronan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ClassName: UserServiceImpl
 * Package: com.ronan.service.Impl
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 15:13
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        // 对密码尽心加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userMapper.addUser(username, password);
    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalContext.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(Integer id, String newPwd) {
        userMapper.updatePwd(newPwd, id);
    }
}
