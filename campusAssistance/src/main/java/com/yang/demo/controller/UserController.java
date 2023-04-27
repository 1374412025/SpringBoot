package com.yang.demo.controller;


import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.mapper.UserMapper;
import com.yang.demo.pojo.Msg;
import com.yang.demo.pojo.Post;
import com.yang.demo.pojo.User;
import com.yang.demo.service.UserService;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ?û? 前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody()Map param){
        User user = userService.getById((String) param.get("userOpenid"));
        user.setUserIntroduce((String) param.get("userIntroduce"));
        user.setUserSex((String) param.get("userSex"));
        user.setUserPhone((String) param.get("userPhone"));
        user.setUserLocation((String) param.get("userLocation"));
        user.setUserNickname((String) param.get("userNickname"));

        boolean result = userService.updateById(user);
        Msg msg = new Msg();
        if (result){
            msg.setResult(user);
        }else {
            msg.setResult("false");
        }
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/createUser")
    public String createUser(@RequestBody()Map param){

        User user = new User();

        user.setUserNickname((String) param.get("userNickname"));
        user.setUserHeadimgurl((String) param.get("userHeadimgurl"));
        user.setUserOpenid((String) param.get("userOpenid"));
        user.setUserKey("1");

        user.setUserPhone(" ");
        user.setUserLocation("");
        user.setUserIntroduce("");

        boolean result = userService.saveOrUpdate(user);
        Msg msg = new Msg();
        if (result){
            msg.setResult(result);
        }else {
            msg.setResult("false");
        }
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/queryUserById")
    public JSON queryUserById(@RequestBody()Map param){
        User user = userService.getById((String) param.get("userOpenid"));
        Msg msg = new Msg();
        msg.setResult(user);
        return JSONUtil.parse(msg);
    }
    @RequestMapping("/getAllUser")
    public JSON getAllUser(@RequestBody()Map param){
        List<User> list = null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_key",1);

        //List<User> list= selectList(wrapper);

        return JSONUtil.parse(list);
    }



    }

