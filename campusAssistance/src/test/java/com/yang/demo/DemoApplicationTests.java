package com.yang.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.User;
import com.yang.demo.service.UserCommentService;
import com.yang.demo.service.UserPostService;
import com.yang.demo.service.UserService;
import com.yang.demo.view.UserPost;
import com.yang.demo.view.userComment;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.yang.demo.mapper")
class DemoApplicationTests {
    
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserOpenid("1");
        user.setUserKey("1");
        user.setUserNickname("彭于晏");
        user.setUserHeadimgurl("1");
        user.setUserSex("1");
        user.setUserIntroduce("自我介绍");
        user.setUserLocation("江安");
        user.setUserPhone("110");
        System.out.println("--------------------------------------");
        System.out.println(user);
        System.out.println(user.getClass());
        boolean save = userService.save(user);

    }

    @Autowired
    @Qualifier("UserCommentServiceImpl")
    private UserCommentService userCommentService;

    @Test
    public void test(){
        List<userComment> userComments = userCommentService.list(null);
        userComments.forEach(System.out::println);
    }


    @Autowired
    @Qualifier("UserPostServiceImpl")
    private UserPostService userPostService;

    @Test
    public void ttest1(){
        QueryWrapper<UserPost> wr = new QueryWrapper<>();
        String a = "123";
        wr.like(StringUtils.isNotBlank(a),"post_title",a).or().like(StringUtils.isNotBlank(a),"post_content",a);


        List<UserPost> list = userPostService.list(wr);

        list.forEach(System.out::println);

    }
}
