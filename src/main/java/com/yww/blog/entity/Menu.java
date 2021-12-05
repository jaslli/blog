package com.yww.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单或权限实体类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "菜单或权限表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("路由地址")
    @TableField("path")
    private String path;

    @ApiModelProperty("组件名称")
    @TableField("component")
    private String component;

    @ApiModelProperty("菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("排序字段")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("权限标识字段")
    @TableField("code")
    private String code;

    @ApiModelProperty("父级数据ID")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty("菜单类型 0菜单 1按钮（权限）")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty("是否隐藏 0不隐藏 1隐藏")
    @TableField("is_hidden")
    private Boolean hidden;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
