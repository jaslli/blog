package com.yww.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yww.blog.dto.UserDTO;
import com.yww.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户ID获取角色名称
     * @param id 用户id
     * @return  角色名称
     */
    String getRoleNameById(@Param("id") String id);

    /**
     * 获取用户列表数据
     * @return 获取用户列表数据
     */
    List<UserDTO> getUserList();
}
