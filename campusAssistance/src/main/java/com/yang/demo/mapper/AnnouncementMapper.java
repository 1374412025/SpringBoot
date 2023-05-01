package com.yang.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.demo.pojo.Announcement;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-05-02 0:26
 */

@Mapper
@Repository
public interface AnnouncementMapper extends BaseMapper<Announcement> {
}
