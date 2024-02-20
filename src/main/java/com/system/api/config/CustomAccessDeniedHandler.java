package com.system.api.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义错误返回
 *
 * @author zhangyongkai
 * @date 2024/2/20-16:38
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.setContentType("application/json;charset=UTF-8");

        String jsonPayload = "{\"message\" : \"%s\", \"timestamp\" : \"%s\"}";
        response.getWriter().write(String.format(jsonPayload, accessDeniedException.getMessage(), System.currentTimeMillis()));
        response.getWriter().flush();
    }
}
