package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * ????
 * </p>
 *
 * @author jing
 * @since 2023-03-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    private String replyId;

    private String losUserId;

    private String lfId;

    private String marUserId;

    private String mkId;

    private String helUserId;

    private String hpId;

    private String replyContent;

    private String replyPicture;

}
