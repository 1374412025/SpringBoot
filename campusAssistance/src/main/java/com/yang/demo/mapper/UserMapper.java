package com.yang.demo.mapper;

import com.yang.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
 * <p>
 * ?û? Mapper 接口
 * </p>
 *
 * @author jing
 * @since 2023-03-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
