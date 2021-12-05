package com.yww.blog.security;

import com.yww.blog.util.ResponseUtil;
import com.yww.blog.util.Result;
import com.yww.blog.util.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     登录失败的处理类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 20:12
 **/
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException {
        ResponseUtil.printlnOut(response,Result.failure(ResultCode.USER_ERROR));
    }

}
