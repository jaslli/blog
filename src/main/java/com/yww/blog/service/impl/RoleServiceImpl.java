package com.yww.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.entity.Role;
import com.yww.blog.mapper.RoleMapper;
import com.yww.blog.mapper.UserRoleMapper;
import com.yww.blog.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private final UserRoleMapper userRoleMapper;
    @Autowired
    public RoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public String getRoleCodeByUserId(String userId) {
        String roleId = userRoleMapper.getRoleId(userId);
        return baseMapper.getCode(roleId);
    }

    @Override
    public String getRoleIdByUserId(String userId) {
        return userRoleMapper.getRoleId(userId);
    }

    @Override
    public String getRoleNameByUserId(String userId) {
        return userRoleMapper.getRoleName(userId);
    }

}
