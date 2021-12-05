package com.yww.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yww.blog.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色ID获取角色的权限标识
     * @param id   角色ID
     * @return      权限标识
     */
    String getCode(@Param("id")String id);

}
