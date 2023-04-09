package com.jing.helloworld;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-03-31 11:54
 */


@Data
@Service
public class AutoWiredBean {
    private int id;
    private String name;

    public AutoWiredBean(){
        System.out.println("无参构造函数");
    }

    public AutoWiredBean(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("有参构造函数");
    }
}
