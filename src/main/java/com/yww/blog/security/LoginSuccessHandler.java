package com.yww.blog.security;

import com.yww.blog.util.JwtUtil;
import com.yww.blog.util.ResponseUtil;
import com.yww.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     登录成功处理类
 *     登陆成功就返回Token
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 20:20
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    @Autowired
    public LoginSuccessHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {
        String token = jwtUtil.createToken(authentication.getName());
        ResponseUtil.printlnOut(response,Result.success(token));
    }

}
