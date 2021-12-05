package com.yww.blog.security;

import com.yww.blog.util.ResponseUtil;
import com.yww.blog.util.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     退出登陆处理类
 *  </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/5 19:27
 **/
@Component
public class AuthLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // TODO 清空redis中的token信息
        ResponseUtil.printlnOut(response,Result.success());
    }

}
