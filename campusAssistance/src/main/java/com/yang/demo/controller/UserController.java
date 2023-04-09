package com.yang.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.User;
import com.yang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ?û? 前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-03-29
 */
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;

    @RequestMapping("/queryAllUser")
    public String queryAllUser(){
        QueryWrapper<User> w = new QueryWrapper<>();
        List<User> list = userService.list(w);
        return list.toString();
    }

}

