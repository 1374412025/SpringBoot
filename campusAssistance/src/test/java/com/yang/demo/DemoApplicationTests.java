package com.yang.demo;

import com.yang.demo.pojo.User;
import com.yang.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.yang.demo.mapper")
class DemoApplicationTests {
    
    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserId("123243l");
        user.setUserCollege("34324");
        user.setUserEmail("sfsd ");
        user.setUserGender(false);
        user.setUserLocation("fgdsf");
        user.setUserPhone("fsadfas");
        user.setUserPwd("fdsfgsdf");
        System.out.println("--------------------------------------");
        System.out.println(user);
        System.out.println(user.getClass());
        boolean save = userService.save(user);

    }

}
