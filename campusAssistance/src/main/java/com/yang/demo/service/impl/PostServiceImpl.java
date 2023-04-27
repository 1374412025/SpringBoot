package com.yang.demo.service.impl;

import com.yang.demo.pojo.Post;
import com.yang.demo.mapper.PostMapper;
import com.yang.demo.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ??? 服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Service
@Qualifier("PostServiceImpl")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
