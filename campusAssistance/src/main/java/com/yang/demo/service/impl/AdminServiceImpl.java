package com.yang.demo.service.impl;

import com.yang.demo.pojo.Admin;
import com.yang.demo.mapper.AdminMapper;
import com.yang.demo.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ????Ա 服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Service
@Qualifier("AdminServiceImpl")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
