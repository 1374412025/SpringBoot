package com.yang.demo.controller;

import com.yang.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-05-02 0:22
 */

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    @Qualifier("AnnouncementServiceImpl")
    private AnnouncementService announcementService;



}
