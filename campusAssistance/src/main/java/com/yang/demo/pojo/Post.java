package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * ???
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "user_openid", type = IdType.INPUT)
    private String userOpenid;

    @TableId(value = "post_id", type=IdType.ID_WORKER_STR )
    private String postId;

    private String postType;//0是Lostfound,1是求助寻问,2是跳蚤市场

    private String postTitle;

    private String postContent;

    private String postImgurl;

    private String postImgurl2;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH时mm分ss秒")
    private Date postDate;


}
