package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * ?û?
 * </p>
 *
 * @author jing
 * @since 2023-03-29
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    private String userPwd;

    private Boolean userGender;

    private String userCollege;

    private String userPhone;

    private String userLocation;

    private String userEmail;


}
