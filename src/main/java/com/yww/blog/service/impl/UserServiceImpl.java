package com.yww.blog.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.dto.UserDTO;
import com.yww.blog.entity.Menu;
import com.yww.blog.entity.User;
import com.yww.blog.mapper.UserMapper;
import com.yww.blog.service.IMenuService;
import com.yww.blog.service.IRoleService;
import com.yww.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final IRoleService roleService;
    private final IMenuService menuService;
    @Autowired
    public UserServiceImpl(IRoleService roleService, IMenuService menuService) {
        this.roleService = roleService;
        this.menuService = menuService;
    }


    @Override
    public User getByUsername(String username) {
        return baseMapper.selectOne(
                new QueryWrapper<User>().eq("username",username)
        );
    }

    @Override
    public List<GrantedAuthority> getUserAuthorityInfo(String userId) {
        // TODO 先从redis缓存中获取，然后在查表
        StringBuilder authority = new StringBuilder();
        // 获取角色信息（一个用户只有一个角色信息）
        String roleCode = roleService.getRoleCodeByUserId(userId);
        if (StrUtil.isNotBlank(roleCode)) {
            authority.append("ROLE_").append(roleCode);
        }
        List<Menu> menus = menuService.getMenusByUserId(userId);
        if (menus.size() > 0) {
            for (Menu menu : menus) {
                authority.append(",").append(menu.getCode());
            }
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority.toString());
    }

    @Override
    public List<UserDTO> getUserList() {
        return baseMapper.getUserList();
    }

}
