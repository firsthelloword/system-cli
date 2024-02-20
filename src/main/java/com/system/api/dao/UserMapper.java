package com.system.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date 2023/8/11 10:23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUser(String username,String password);


    Integer addUser(User user);
}
