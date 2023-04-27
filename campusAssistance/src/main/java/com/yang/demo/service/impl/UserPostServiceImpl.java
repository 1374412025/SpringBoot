package com.yang.demo.service.impl;

import com.yang.demo.view.UserPost;
import com.yang.demo.mapper.UserPostMapper;
import com.yang.demo.service.UserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-04-25
 */
@Service
@Qualifier("UserPostServiceImpl")
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {

}
