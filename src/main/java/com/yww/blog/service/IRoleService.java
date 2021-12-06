package com.yww.blog.service;

import com.yww.blog.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据用户ID获取角色的权限标识（一个用户只对应额一个角色）
     * @param userId    用户ID
     * @return          角色的权限标识
     */
    String getRoleCodeByUserId(String userId);

    /**
     * 根据用户ID查询角色ID
     * @param userId    用户ID
     * @return          角色ID
     */
    String getRoleIdByUserId(String userId);

    /**
     * 根据用户ID查询角色名称
     * @param userId    用户ID
     * @return          角色名称
     */
    String getRoleNameByUserId(String userId);

}
