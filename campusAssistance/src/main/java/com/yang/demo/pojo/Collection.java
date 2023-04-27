package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * ?ղ
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "user_openid", type = IdType.ID_WORKER_STR)
    private String userOpenid;

    private String posUserOpenid;

    private String postId;
    @TableId(value = "collection_id", type=IdType.ID_WORKER_STR )
    private String collectionId;


}
