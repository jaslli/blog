package com.yww.blog.security;

import com.yww.blog.util.ResponseUtil;
import com.yww.blog.util.Result;
import com.yww.blog.util.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     认证失败的处理类（没权限访问处理类）
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/4 11:37
 **/
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        ResponseUtil.printlnOut(response,Result.failure(ResultCode.FORBIDDEN));
    }

}
