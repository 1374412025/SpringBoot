package com.yang.demo.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Msg;
import com.yang.demo.service.UserCommentService;
import com.yang.demo.view.userComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ??? 前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@RestController
    @RequestMapping("/comment")
public class CommentController {

    @Autowired
    @Qualifier("UserCommentServiceImpl")
    private UserCommentService userCommentService;

    @RequestMapping("/queryUserCommentByPostId")
    public String queryUserCommentByPostId(@RequestParam("postId") String  postId){
//        String post_id = (String) param.get("postId");

        QueryWrapper<userComment> wr = new QueryWrapper<>();
        wr.eq("post_id",postId);
        List<userComment> list = userCommentService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);

        return JSONUtil.toJsonStr(msg);

    }

}

