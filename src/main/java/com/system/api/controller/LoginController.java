package com.system.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.system.api.common.R;
import com.system.api.entity.User;
import com.system.api.entity.param.UserParams;
import com.system.api.service.UserService;
import com.system.api.util.JwtUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "登录接口", tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 注册
     *
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody UserParams userParams) {

        return R.ok();
    }

    /**
     * 密码登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody User user) {

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword());
        List<User> list = userService.list(userLambdaQueryWrapper);
        if(list.size() < 0){
             return R.fail("账号或密码错误");
        }
        return R.ok(list.get(0));
    }



    @GetMapping("/test")
    public R testController(){
        return R.ok("hello");
    }

}
