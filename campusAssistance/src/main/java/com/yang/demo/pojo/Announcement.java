package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-05-02 0:27
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "comment_id", type = IdType.ID_WORKER_STR)
    private String AnnouncementId;

    private String AnnouncementContent;

    private Date AnnouncementDate;
}
