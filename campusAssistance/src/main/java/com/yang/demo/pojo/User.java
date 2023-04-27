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
 * ?û?
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_openid", type = IdType.INPUT)
    private String userOpenid;

    private String userKey;

    private String userHeadimgurl;

    private String userNickname;

    private String userSex;

    private String userLocation;

    private String userPhone;

    private String userIntroduce;


}
