package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "pos_user_openid", type = IdType.ID_WORKER_STR)
    private String posUserOpenid;

    private String postId;

    private String userOpenid;
    @TableId(value = "comment_id", type = IdType.ID_WORKER_STR)
    private String commentId;

    private String commentContent;

    private Date commentDate;
    private String flag;


}
