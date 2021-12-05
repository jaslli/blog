package com.yww.blog.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.yww.blog.util.ResultCode.FAILED;

/**
 * <p>
 *     自定义异常类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 16:16
 **/
@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code = FAILED.getStatus();

    /**
     * 错误信息
     */
    private final String message;

    public GlobalException(String message) {
        this.message = message;
    }

    public GlobalException(ResultCode resultCode) {
        this.code = resultCode.getStatus();
        this.message = resultCode.getMessage();
    }

}
