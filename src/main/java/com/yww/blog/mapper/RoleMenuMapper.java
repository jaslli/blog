package com.yww.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yww.blog.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 Mapper 接口
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据角色ID查询菜单的ID
     * @param roleId    角色ID
     * @return          菜单ID
     */
    List<String> getMenuIdsByRoleId(@Param("roleId") String roleId);

}
