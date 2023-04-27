package com.yang.demo.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @version: java version 1.8
 * @Author: Tao
 * @description:
 * @date: 2023-04-22 20:38
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Msg {
    private Object result;
    private String m;
    private int count;
}
