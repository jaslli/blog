package com.yww.blog.security;

import com.yww.blog.util.ResponseUtil;
import com.yww.blog.util.Result;
import com.yww.blog.util.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     未登录或登陆过期处理类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/4 11:37
 **/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ResponseUtil.printlnOut(response,Result.failure(ResultCode.NOT_LOGIN));
    }
}
