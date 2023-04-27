package com.yang.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Collection;
import com.yang.demo.pojo.Msg;
import com.yang.demo.pojo.Post;
import com.yang.demo.service.CollectionService;
import com.yang.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

        Collection col = new Collection();

        col.setPosUserOpenid("1");
        col.setUserOpenid((String) param.get("userOpenid"));
        col.setPostId((String) param.get("postId"));

        boolean result = collectionService.saveOrUpdate(col);

//        Msg msg = new Msg();
//        if (result){
//            msg.setResult(msg);
//        }else {
//            msg.setResult("false");
//        }

        return JSONUtil.toJsonStr(col) ;
    }

}

