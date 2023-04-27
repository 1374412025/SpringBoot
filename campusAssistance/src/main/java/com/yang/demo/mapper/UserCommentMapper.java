package com.yang.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.demo.pojo.Post;
import com.yang.demo.view.userComment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-04-24 17:28
 */

@Mapper
@Repository
public interface UserCommentMapper extends BaseMapper<userComment> {
}
