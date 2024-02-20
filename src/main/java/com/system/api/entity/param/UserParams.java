package com.system.api.entity.param;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhangyongkai
 * @date 2024/2/20-09:42
 */
@Data
public class UserParams {

    private Integer id;

    private String email;

    private String password;

    private LocalDateTime createTime;

    private String username;

    /**
     * 1 普通员工 2 管理员
     */
    private Integer userType;
}
