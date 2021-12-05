package com.yww.blog.security;

import com.yww.blog.entity.User;
import com.yww.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     UserDetailsService的是实现类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/4 11:55
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserService userService;
    @Autowired
    public UserDetailServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        User user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        return AccountUser.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(userService.getUserAuthorityInfo(user.getId()))
                .enabled(user.getEnable())
                .build();
    }

}
