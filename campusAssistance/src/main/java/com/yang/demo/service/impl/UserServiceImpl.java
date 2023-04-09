package com.yang.demo.service.impl;

import com.yang.demo.pojo.User;
import com.yang.demo.mapper.UserMapper;
import com.yang.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ?û? 服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-03-29
 */
@Service
@Qualifier("UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
