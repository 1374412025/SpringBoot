package com.yang.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jing
 * @since 2023-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "announcement_id", type = IdType.ID_WORKER_STR)
    private String announcementId;

    private String announcementContent;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH时mm分ss秒")
    private Date announcementDatatime;


}
