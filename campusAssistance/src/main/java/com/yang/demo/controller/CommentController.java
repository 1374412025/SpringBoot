package com.yang.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Comment;
import com.yang.demo.pojo.Msg;

import com.yang.demo.pojo.Post;
import com.yang.demo.service.CommentService;
import com.yang.demo.service.PostService;
import com.yang.demo.service.UserCommentService;
import com.yang.demo.view.userComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
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
//    public String queryUserCommentByPostId(@RequestParam("postId") String  postId){
    public String queryUserCommentByPostId(@RequestBody() Map param){

        QueryWrapper<userComment> wr = new QueryWrapper<>();
        wr.eq("post_id",(String)param.get("data"));

        List<userComment> list = userCommentService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/getDetailByPostIdList")
    public String getDetailByPostIdList(@RequestBody() Map param){

        QueryWrapper<userComment> wr = new QueryWrapper<>();
        wr.orderByAsc("flag");
        List<String> postid= (List<String>) param.get("PostIdlist");

        List<userComment> userComments = new LinkedList<>();

        for (String id : postid) {
            wr.eq("post_id",id);
            List<userComment> list = userCommentService.list(wr);
            userComments.addAll(list);
        }

        Msg msg = new Msg();
        msg.setResult(userComments);
        return JSONUtil.parse(msg).toString();
    }


    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;

    @RequestMapping("/createComment")
    public String createComment(@RequestBody() Map param){

        Comment comment = new Comment();

        comment.setPosUserOpenid("qweqwe");
        comment.setCommentContent((String) param.get("commentContent"));
        DateTime now = DateTime.now();
        comment.setCommentDate(now);
        comment.setPostId((String) param.get("postId"));
        comment.setUserOpenid((String) param.get("openId"));
        comment.setFlag("0");

        boolean result = commentService.saveOrUpdate(comment);
        Msg msg = new Msg();
        if (result){
            QueryWrapper<Comment> wr = new QueryWrapper<>();
            wr.eq("user_openid",param.get("userOpenid"));
            Comment one = commentService.getOne(wr);
            msg.setResult(one);
        }else {
            msg.setResult("false");
        }
        return JSONUtil.toJsonStr(msg) ;

    }

    @RequestMapping("/getCommentByPostId")
    public String getCommentByPostId(@RequestBody() Map param){

        QueryWrapper<Comment> wr = new QueryWrapper<>();
        wr.eq("post_id",(String)param.get("data"));

        List<Comment> list = commentService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/modifyCommentFlag")
    public String modifyCommentFlag(@RequestBody() Map param){

        QueryWrapper<Comment> wr = new QueryWrapper<>();
        wr.eq("comment_id",(String)param.get("data"));

        Comment comment = commentService.getOne(wr);
        comment.setFlag("1");

        wr.orderByAsc("flag");
        commentService.saveOrUpdate(comment);

        Msg msg = new Msg();
        msg.setResult(comment);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(@RequestBody() Map param){

        QueryWrapper<Comment> wr = new QueryWrapper<>();
        wr.eq("comment_id",(String)param.get("data"));

        commentService.remove(wr);

        Msg msg = new Msg();
        msg.setResult("删除成功");
        return JSONUtil.parse(msg).toString();
    }
}

