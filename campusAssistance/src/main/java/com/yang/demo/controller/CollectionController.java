package com.yang.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Collection;
import com.yang.demo.pojo.Comment;
import com.yang.demo.pojo.Msg;
import com.yang.demo.pojo.Post;
import com.yang.demo.service.CollectionService;
import com.yang.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ?ղ 前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    @Qualifier("CollectionServiceImpl")
    private CollectionService collectionService;

    @RequestMapping("/createCollection")
    public String createCollection(@RequestBody() Map param){

        QueryWrapper<Collection> wr = new QueryWrapper<>();
        wr.eq("user_openid",param.get("openid")).eq("post_id",param.get("postid"));
        int count=collectionService.count(wr);//有就删了

        Msg msg = new Msg();

        if(count>=1){
            boolean result = collectionService.remove(wr);
            msg.setResult(0);
        }else{
            Collection collection = new Collection();
            collection.setUserOpenid((String) param.get("openid"));
            collection.setPostId((String) param.get("postid"));
            boolean result = collectionService.saveOrUpdate(collection);
            msg.setResult(1);
        }

        return JSONUtil.toJsonStr(msg) ;
    }

    @RequestMapping("/queryPostIdListByOpenid")
    public String queryPostIdListByOpenid(@RequestBody() Map param) {

        QueryWrapper<Collection> wr = new QueryWrapper<>();
        wr.eq("user_openid",param.get("openid"));

        List<Collection> list = collectionService.list(wr);

        Msg msg = new Msg();
        msg.setResult(list);
        return JSONUtil.toJsonStr(msg);
    }

}

