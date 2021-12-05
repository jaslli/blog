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
 *      分类实体类
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@Getter
@Setter
@TableName("category")
@ApiModel(value = "Category对象", description = "分类实体类")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("父级分类ID")
    @TableField("parent_id")
    private String parentId;

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
