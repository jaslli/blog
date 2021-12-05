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
 *      友链实体对象
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@Getter
@Setter
@TableName("link")
@ApiModel(value = "Link对象", description = "友链实体对象")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("是否是友链 0是分组 1是友链")
    @TableField("is_type")
    private Boolean type;

    @ApiModelProperty("友链名称或者是分组名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("友链头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("友链地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("友链描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("分组ID")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty("排序字段")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
