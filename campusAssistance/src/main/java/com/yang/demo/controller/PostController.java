package com.yang.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Msg;
import com.yang.demo.pojo.Post;
import com.yang.demo.service.PostService;
import com.yang.demo.service.UserCommentService;
import com.yang.demo.service.UserPostService;
import com.yang.demo.view.UserPost;
import com.yang.demo.view.userComment;
import javafx.geometry.Pos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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
@RequestMapping("/post")
public class PostController {
    @Autowired
    @Qualifier("PostServiceImpl")
    private PostService postService;

    @RequestMapping("/createPost")
    public String createPost(@RequestBody() Map param){

        Post post = new Post();
        post.setUserOpenid((String) param.get("userOpenid"));
        post.setPostType((String) param.get("postType"));
        post.setPostTitle((String) param.get("postTitle"));
        post.setPostContent((String) param.get("postContent"));
        post.setPostImgurl((String) param.get("postImgurl"));
        post.setPostImgurl2((String) param.get("postImgurl2"));
        DateTime now = DateTime.now();
        post.setPostDate(now);

        boolean result = postService.saveOrUpdate(post);
        Msg msg = new Msg();
        if (result){
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.eq("user_openid",param.get("userOpenid")).eq("post_imgurl",param.get("postImgurl"));
            Post one = postService.getOne(wrapper);
            msg.setResult(one);
        }else {
            msg.setResult("false");
        }
        return JSONUtil.toJsonStr(msg) ;
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestBody() Map param){

        QueryWrapper<Post> wr = new QueryWrapper<>();
        wr.eq("post_id", (String) param.get("postId"));
        boolean flag = postService.remove(wr);

        Msg msg = new Msg();
        msg.setResult(flag);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/getPostIdByOpenId")
    public String getPostIdByOpenId(@RequestBody() Map param) {
        QueryWrapper<Post> wr = new QueryWrapper<>();
        wr.eq("user_openid", param.get("Openid"));
        List<Post> list = postService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);

        return JSONUtil.parse(msg).toString();

    }

    @Autowired
    @Qualifier("UserPostServiceImpl")
    private UserPostService userPostService;

    @RequestMapping("/queryUserPost")
    public String queryUserPost(@RequestBody() Map param) {
//    public String queryUserPostByPostType(@RequestParam() String  postType) {

        List<UserPost> list = userPostService.list(null);
        Msg msg = new Msg();
        msg.setResult(list);
//        list.forEach(System.out::println);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/queryPostInfo")
    public String queryPostInfo(@RequestBody() Map param) {
//    public String queryUserPostByPostType(@RequestParam() String  postType) {
        QueryWrapper<UserPost> wr = new QueryWrapper<>();
        String a=(String) param.get("data");
        wr.like(StringUtils.isNotBlank((String)a),"post_title",a).or().like(StringUtils.isNotBlank((String)a),"post_content",a);

        List<UserPost> list = userPostService.list(wr);
        Msg msg = new Msg();
        msg.setResult(list);
//        list.forEach(System.out::println);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/getPostDetailByOpenId")
    public String getPostDetailByOpenId(@RequestBody() Map param) {
//    public String queryUserPostByPostType(@RequestParam() String  postType) {
        QueryWrapper<UserPost> wr = new QueryWrapper<>();
        wr.eq("user_openid", param.get("Openid"));

        List<UserPost> list = userPostService.list(wr);
        Msg msg = new Msg();
        msg.setResult(list);

        return JSONUtil.parse(msg).toString();
    }
    @RequestMapping("/queryAUserPost")
    public String queryAUserPost(@RequestBody() Map param) {
//    public String queryUserPostByPostType(@RequestParam() String  postType) {

        QueryWrapper<UserPost> wr = new QueryWrapper<>();
        wr.eq("user_openid",param.get("data"));

        List<UserPost> list = userPostService.list(wr);
        Msg msg = new Msg();
        msg.setResult(list.get(0));
//        list.forEach(System.out::println);
        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/queryUserPostByUserOpenid")
    public String queryUserPostByUserOpenid(@RequestBody() Map param) {
//    public String queryUserPostByPostType(@RequestParam() String  postType) {

        QueryWrapper<UserPost> wr = new QueryWrapper<>();
        wr.eq("user_openid",param.get("data"));


        List<UserPost> list = userPostService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);
//        list.forEach(System.out::println);

        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/queryPostDetailListByPostIdList")
    public String getDetailByPostIdList(@RequestBody() Map param){



        List<String> postid= (List<String>) param.get("postIdList");

        List<UserPost> userPosts = new LinkedList<>();

        for (String id : postid) {
            QueryWrapper<UserPost> wr = new QueryWrapper<>();
            wr.eq("post_id",id);
            List<UserPost> list = userPostService.list(wr);
            userPosts.addAll(list);
        }

        Msg msg = new Msg();
        msg.setResult(userPosts);
        return JSONUtil.parse(msg).toString();
    }


}

