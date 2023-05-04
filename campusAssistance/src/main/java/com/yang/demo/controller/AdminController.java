package com.yang.demo.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Admin;
import com.yang.demo.pojo.Msg;
import com.yang.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * ????Ա 前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @RequestMapping("getAdminKey")
    public String getAdminKey(@RequestBody() Map param){

        QueryWrapper<Admin> wr = new QueryWrapper<>();
        wr.eq("admin_openid", (String) param.get("openid"));

        Msg msg = new Msg();
        Admin admin = adminService.getOne(wr);
        if(admin==null){
            msg.setResult("0");
        }else {
            msg.setResult("1");
        }
        return JSONUtil.toJsonStr(msg);
    }



}

