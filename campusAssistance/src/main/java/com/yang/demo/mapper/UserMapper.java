package com.yang.demo.mapper;

import com.yang.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ?û? Mapper 接口
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
