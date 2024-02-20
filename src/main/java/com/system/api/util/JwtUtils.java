package com.system.api.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.system.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhangyongkai
 * @date 2024/2/20-14:31
 */
@Component
public class JwtUtils {

    @Value("${jwt.key}")
    private String jwtKey;

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return JWT.create()
                // 设置签发时间
                .setIssuedAt(DateUtil.date())
                //设置过期时间
                .setExpiresAt(DateUtil.date(LocalDateTime.now().plusSeconds(60 * 24 * 7)))
                .setPayload("userId", principal.getId())
                .setPayload("username", principal.getId())
                .setKey(jwtKey.getBytes())
                .sign();

    }

    public boolean validateToken(String token) {
        return JWT.of(token).setKey(jwtKey.getBytes()).validate(0);

    }

    public String getUsernameFromJWT(String token) {
        // 从JWT中提取用户名
        final JWT jwt = JWTUtil.parseToken(token);
        return jwt.getPayload("username").toString();
    }

}
