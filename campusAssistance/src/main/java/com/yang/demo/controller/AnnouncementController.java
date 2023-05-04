package com.yang.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.demo.pojo.Announcement;
import com.yang.demo.pojo.Msg;
import com.yang.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jing
 * @since 2023-05-02
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    @Qualifier("AnnouncementServiceImpl")
    private AnnouncementService announcementService;

    @RequestMapping("/updateAnnouncement")
    public String updateAnnouncement(@RequestBody() Map param){

        QueryWrapper<Announcement> wr = new QueryWrapper<>();
        wr.eq("announcement_id","1");

        Announcement one = announcementService.getOne(wr);
        one.setAnnouncementContent((String)param.get("content"));
        DateTime now = DateTime.now();
        one.setAnnouncementDatatime(now);

        boolean a = announcementService.saveOrUpdate(one);

        Msg msg = new Msg();
        msg.setResult(a);

        return JSONUtil.parse(msg).toString();
    }

    @RequestMapping("/getAnnouncement")
    public String getAnnouncement(@RequestBody() Map param){

        QueryWrapper<Announcement> wr = new QueryWrapper<>();
        wr.eq("announcement_id","1");
        Announcement one = announcementService.getOne(wr);

        Msg msg = new Msg();
        msg.setResult(one);

        return JSONUtil.parse(msg).toString();
    }
}

