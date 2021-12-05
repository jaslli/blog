package com.yww.blog.security;

import cn.hutool.core.util.StrUtil;
import com.yww.blog.constant.JwtConstant;
import com.yww.blog.entity.User;
import com.yww.blog.service.IUserService;
import com.yww.blog.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     认证流程（验证该用户是否有权限操作）
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 22:16
 **/

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    IUserService userService;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        // 从请求头中获取token
        String jwt = request.getHeader(JwtConstant.TOKEN_HEADER);
        // 如果请求头没有Token信息直接放行给下一个过滤器
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        // 解析token,获取claims信息
        Claims claims = jwtUtil.getClaimsByToken(jwt);
        if (claims == null) {
            throw new JwtException("Token出现异常");
        }
        if (jwtUtil.isExpired(claims)) {
            throw new JwtException("Token已经过期");
        }
        String username = claims.getSubject();
        // 获取用户的权限信息
        User user = userService.getByUsername(username);
       // 填充SecurityContextHolder
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        userService.getUserAuthorityInfo(user.getId())
                );
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

}
