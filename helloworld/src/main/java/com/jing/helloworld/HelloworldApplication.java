package com.jing.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//本身就是Spring的一个组件
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {

        SpringApplication.run(HelloworldApplication.class, args);
    }

}
