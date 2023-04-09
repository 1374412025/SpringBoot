package com.jing.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-03-31 11:56
 */


@SpringBootTest
class Springboot02WebApplicationTests {


    private AutoWiredBean autoWiredBean;

    @Autowired
    public Springboot02WebApplicationTests (AutoWiredBean autoWiredBean){
        this.autoWiredBean = autoWiredBean;
    }


    @Test
    void contextLoads() {
        System.out.println(autoWiredBean);
        System.out.println(autoWiredBean.getId());  //0
        System.out.println(autoWiredBean.getName());    //null

    }

}

