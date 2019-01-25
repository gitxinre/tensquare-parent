package com.xinre.base.controller;

import com.xinre.common.entity.Result;
import com.xinre.common.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller 增强器
 *
 * @author xinre
 * @date 2019/1/18 11:36
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Result exception(Exception e) {
        e.printStackTrace();
        return new Result(StatusCode.ERROR, false, e.getMessage());
    }

}
