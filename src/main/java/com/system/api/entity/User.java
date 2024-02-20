package com.system.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @date 2023/8/11 10:22
 */

@Data
@NoArgsConstructor
@TableName("sys_user")
public class User implements UserDetails {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String email;

    private String password;

    private Date createTime;

    private String username;

    /**
     * 1 普通员工 2 管理员
     */
    private Integer userType;

    private String phone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
