package com.xinre.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果
 *
 * @author xinre
 * @date 2019/1/16 16:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private int code;
    private boolean flag;
    private String message;
    private Object data;

    public Result(int code, boolean flag, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

}
