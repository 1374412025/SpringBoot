package com.yang.demo.mapper;

import com.yang.demo.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ??? Mapper 接口
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}
