package com.example.bookapi.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.system.api.entity.User;
import com.system.api.service.UserService;
import com.system.api.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyongkai
 * @date 2024/2/20-10:31
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void test() {
        List<User> list = userService.list();
        System.out.println(list);
    }

    @Test
    public void test2() {
        UserDetails userDetails = userDetailsService.loadUserByUsername("123");
        System.out.println(userDetails);
    }

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.key}")
    private String jwtKey;

    @Test
    public void generateToken() {
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("userId", "1");
                put("username", "123");
                put("exp", LocalDateTime.now().getSecond() + 60);
            }
        };
        String sign = JWT.create()
                // 设置签发时间
                .setIssuedAt(DateUtil.date())
                .setExpiresAt(DateUtil.date(LocalDateTime.now().plusSeconds(30)))
                .setKey(jwtKey.getBytes())
                .sign();
        System.out.println(sign);
    }

    @Test
    public void testToken(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDg0MjEyNDgsImV4cCI6MTcwODQyMTI3OH0.uKm1wcSYb4m3_Uq5yxlB8JmvpOfHaZ9rWz_ttWxD458";

        System.out.println(JWT.of(token).setKey(jwtKey.getBytes()).validate(0));
    }

}