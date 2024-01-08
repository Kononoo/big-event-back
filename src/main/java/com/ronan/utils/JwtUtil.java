package com.ronan.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: JwtUtil
 * Package: com.ronan.utils
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 16:33
 * @Version: v1.0
 */
public class JwtUtil {
    private static String signKey = "mikasa";    // 签名密钥
    private static Long expire = 86400000L;      //  86400000L;      // 令牌过期时间 24小时

    /**
     * 生成token
     * @param claims
     * @return
     */
    public static String generateJwt(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + expire))
                .sign(Algorithm.HMAC256(signKey));
    }

    /**
     * 解析token，返回数据
     * @param token
     * @return
     */
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(signKey))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
