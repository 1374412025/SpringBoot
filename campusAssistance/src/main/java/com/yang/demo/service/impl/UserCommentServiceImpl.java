package com.yang.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.demo.mapper.PostMapper;
import com.yang.demo.mapper.UserCommentMapper;
import com.yang.demo.pojo.Post;
import com.yang.demo.service.PostService;
import com.yang.demo.service.UserCommentService;
import com.yang.demo.view.userComment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-04-24 17:36
 */

@Service
@Qualifier("UserCommentServiceImpl")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, userComment> implements UserCommentService {

}
