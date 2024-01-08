package com.ronan.interceptor;

import com.ronan.config.ThreadLocalContext;
import com.ronan.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * ClassName: LoginInterceptor
 * Package: com.ronan.interceptor
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:21
 * @Version: v1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        // 从redis中获取token进行验证
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get("token");
            if (redisToken == null) {
                throw new RuntimeException();
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 把数据存到ThreadLocal当中
            ThreadLocalContext.set(claims);
            return true;
        } catch (RuntimeException e) {
            // 响应状态码设为 401 不放行
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空线程数据
        ThreadLocalContext.remove();
    }
}
