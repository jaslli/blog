package com.yww.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yww.blog.dto.UserDTO;
import com.yww.blog.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return  用户信息
     */
    User getByUsername(String username);

    /**
     * 获取用户权限列表
     * @param userId   用户Id
     * @return  用户权限
     */
    List<GrantedAuthority> getUserAuthorityInfo(String userId);

    /**
     * 获取用户列表
     * @return 获取用户列表
     */
    List<UserDTO> getUserList();

}
