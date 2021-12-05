package com.yww.blog.handler;

import com.yww.blog.util.GlobalException;
import com.yww.blog.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 *     全局异常处理
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 16:19
 **/
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理所有异常信息
     * @param e 服务异常
     * @return 异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception e) {
        return Result.failure(e.getMessage());
    }

    /**
     * 处理通用的服务异常信息
     * @param e 服务异常
     * @return 异常信息
     */
    @ExceptionHandler(value = GlobalException.class)
    public Result errorHandler(GlobalException e) {
        return Result.failure(e.getMessage());
    }

}
