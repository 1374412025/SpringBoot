package com.yang.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.demo.mapper.AnnouncementMapper;
import com.yang.demo.pojo.Announcement;
import com.yang.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-05-02 0:36
 */

@Service
@Qualifier("AnnouncementServiceImpl")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {
}
