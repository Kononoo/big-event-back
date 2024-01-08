package com.ronan.controller;

import com.ronan.config.ThreadLocalContext;
import com.ronan.entity.R;
import com.ronan.entity.User;
import com.ronan.service.UserService;
import com.ronan.utils.JwtUtil;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: UserController
 * Package: com.ronan.controller
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 15:01
 * @Version: v1.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @PostMapping("/register")
    public R<String> register(@Pattern(regexp = "^\\w{5,16}$") String username, @Pattern(regexp = "^\\w{5,16}$") String password) {
        log.info("用户注册：{},{}", username, password);

        // if (username != null && username.length() >= 5 && username.length() <= 16 && password != null && password.length() >= 5)
        // 查询用户
        User user = userService.findByUsername(username);
        if (user != null) {
            return R.error("用户名已被占用");
        }
        userService.register(username, password);
        return R.success("注册成功");
    }

    @PostMapping("/login")
    public R<String> login(@Pattern(regexp = "^\\w{5,16}$") String username, @Pattern(regexp = "^\\w{5,16}$") String password) {
        log.info("用户登录：{},{}", username, password);
        // 根据用户名查询用户
        User loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            return R.error("用户名错误");
        }
        // 判断密码是否错误
        if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(loginUser.getPassword())) {
            // 登录成功，生成jwt令牌
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.generateJwt(claims);
            // 将jwt存储在redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set("token", token, 1, TimeUnit.HOURS);
            return R.success(token);
        }
        return R.error("密码错误");
    }

    @GetMapping("/userInfo")
    public R<User> getUserInfo() {
        log.info("获取用户信息");
        // 查询用户信息
        Map<String, Object> claims = ThreadLocalContext.get();
        Integer id = (Integer) claims.get("id");
        User user = userService.findById(id);
        return R.success(user);
    }

    @PutMapping("/update")
    public R<String> updateUserInfo(@RequestBody User user) {
        log.info("更新用户信息：{}", user);
        userService.update(user);
        return R.success("修改信息成功");
    }

    @PatchMapping("/updateAvatar")
    public R<String> updateAvatar(@RequestParam("avatarUrl") String avatarUrl) {
        log.info("修改用户头像:{}", avatarUrl);
        userService.updateAvatar(avatarUrl);
        return R.success("修改头像成功");
    }

    @PutMapping("/updatePwd")
    public R<String> updatePassword() {

    }

}
