package com.yww.blog.config;

import com.yww.blog.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 *     SpringSecurity核心配置类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 16:25
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailureHandler loginFailureHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final UserDetailServiceImpl userDetailService;
    private final AuthLogoutSuccessHandler authLogoutSuccessHandler;

    @Autowired
    public SecurityConfig(LoginSuccessHandler loginSuccessHandler, LoginFailureHandler loginFailureHandler, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler, UserDetailServiceImpl userDetailService, AuthLogoutSuccessHandler authLogoutSuccessHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.userDetailService = userDetailService;
        this.authLogoutSuccessHandler = authLogoutSuccessHandler;
    }

    /**
     * token的过滤器
     */
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }

    /**
     * 密码加密工具
     */
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     *  AuthenticationManager的构造器
     *  需要配置UserDetailService 和 PasswordEncoder
     *  先调用UserDetailService的loadUserByUsername()然后再使用PasswordEncoder.matches()比较
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    /**
     * 配置静态资源的处理，即在resources下的html，css，js文件（暂无用处）
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**/*.html","/resources/**/*.css", "/resources/**/*.js");
    }

    /**
     * 请求白名单
     */
    private static final String[] URL_WHITELIST = {
            // 放行登录和注销登录的请求
            "/login","/logout",
            // 放行Knife4j的主页和swagger的资源请求
            "/doc.html", "/webjars/**","/swagger-resources/**","/v2/**"
    };

    /**
     * SpringSecurity的核心配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 允许跨域
        http.cors().and()
                // 关闭csrf
                .csrf().disable()
                // 使用自定义session管理策略，让 SpringSecurity不创建和使用 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 登录配置
        http.formLogin()
                // 登录页的用户名属性名
                .usernameParameter("username")
                // 登录页的密码属性名
                .passwordParameter("password")
                // 登陆接口请求路径（POST请求）
                .loginProcessingUrl("/login")
                // 登陆成功处理器
                .successHandler(loginSuccessHandler)
                // 登陆失败处理器
                .failureHandler(loginFailureHandler);
        // 注销配置
        http.logout()
                // 注销登陆接口
                .logoutUrl("/logout")
                // 注销成功处理器
                .logoutSuccessHandler(authLogoutSuccessHandler);
        // 异常处理器的配置
        http.exceptionHandling()
                // 未登录处理类
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // 权限不足处理类
                .accessDeniedHandler(jwtAccessDeniedHandler);
        // 自定义配置过滤器
        http.addFilter(jwtAuthenticationFilter());
        // 权限路由配置
        http.authorizeRequests()
                // 请求白名单放行
                .antMatchers(URL_WHITELIST).permitAll()
                // 拦截所有没有权限的请求
                .anyRequest().authenticated();
    }

}
