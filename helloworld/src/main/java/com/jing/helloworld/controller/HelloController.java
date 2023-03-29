package com.jing.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-03-25 11:08
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")//接口
    public String hello(){
        //调用业务,接受前端参数
    return "hello,world";

    }
}
