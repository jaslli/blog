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
 *      文章内容实体类
 * </p>
 *
 * @author yww
 * @since 2021-11-26
 */
@Getter
@Setter
@TableName("article_content")
@ApiModel(value = "ArticleContent对象", description = "文章内容实体对象")
public class ArticleContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("对应的文章ID")
    @TableField("article_id")
    private String articleId;

    @ApiModelProperty("文章内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
