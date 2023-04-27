package com.yang.demo.view;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jing
 * @since 2023-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private String postId;

    private String postType;

    private String postTitle;

    private String postContent;

    private String postImgurl;

    private String postImgurl2;

    @JsonFormat( pattern = "yyyy-MM-dd HH-mm-ss")
    private Date postDate;

    private String userOpenid;

    private String userHeadimgurl;

    private String userNickname;

    private String userSex;

    private String userIntroduce;

    private String userLocation;

    private String userPhone;

}
