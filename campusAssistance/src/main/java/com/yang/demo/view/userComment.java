package com.yang.demo.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-04-24 17:24
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class userComment {

    private String userOpenid;
    private String userHeadimgurl;
    private String userNickname;
    private String userSex;
    private String postId;
    private String commentId;
    private String commentContent;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH时mm分ss秒")
    private Data commentDate;

}
