package com.yww.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *     菜单显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/12/1 21:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuVO {

    /**
     * 数据ID
     */
    private String id;

    /**
     * 名称
     */
    private String title;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件名称
     */
    private String component;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 权限标识字段
     */
    private String code;

    /**
     * 菜单类型 0菜单 1按钮（权限）
     */
    private Boolean type;

    /**
     * 是否隐藏 0不隐藏 1隐藏
     */
    private Boolean hidden;

    /**
     * 分组的子集友链
     */
    private List<MenuVO> children;

}
