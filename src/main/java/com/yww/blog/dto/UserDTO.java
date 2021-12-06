package com.yww.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     用户传输对象
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/6 16:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    /**
     * 数据ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户是否被开启
     */
    private String enable;

    /**
     * 用户角色名称
     */
    private String rolename;

}
