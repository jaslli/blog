package com.yww.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yww.blog.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户ID获取角色ID
     * @param userId 用户ID
     * @return      角色ID
     */
    String getRoleId(@Param("userId")String userId);

}
