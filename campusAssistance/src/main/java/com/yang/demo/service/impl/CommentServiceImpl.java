package com.yang.demo.service.impl;

import com.yang.demo.pojo.Comment;
import com.yang.demo.mapper.CommentMapper;
import com.yang.demo.service.CommentService;
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
@Qualifier("CommentServiceImpl")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
