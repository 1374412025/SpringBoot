package com.yang.demo.mapper;

import com.yang.demo.view.UserPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author jing
 * @since 2023-04-25
 */
@Mapper
@Repository
public interface UserPostMapper extends BaseMapper<UserPost> {

}
