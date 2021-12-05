package com.yww.blog.service.impl;

import com.yww.blog.entity.UserRole;
import com.yww.blog.mapper.UserRoleMapper;
import com.yww.blog.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
