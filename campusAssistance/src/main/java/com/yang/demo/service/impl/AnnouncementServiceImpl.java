package com.yang.demo.service.impl;

import com.yang.demo.pojo.Announcement;
import com.yang.demo.mapper.AnnouncementMapper;
import com.yang.demo.service.AnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-05-02
 */
@Service
@Qualifier("AnnouncementServiceImpl")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

}
