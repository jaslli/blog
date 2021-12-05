package com.yww.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  文章实体类
 * </p>
 *
 * @author yww
 * @since 2021-11-21
 */
@Getter
@Setter
@TableName("article")
@ApiModel(value = "Article对象", description = "文章实体类")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("文章分类")
    @TableField("category_id")
    private String categoryId;

    @ApiModelProperty("文章封面")
    @TableField("cover")
    private String cover;

    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("文章描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("是否置顶 0没置顶 1置顶")
    @TableField("is_top")
    private Boolean top;

    @ApiModelProperty("是否发表 0没发表 1发表")
    @TableField("is_publish")
    private Boolean publish;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
