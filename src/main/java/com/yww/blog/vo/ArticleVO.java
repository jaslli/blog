package com.yww.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 *     文章显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/21 21:11
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVO {

    /**
     * 数据ID
     */
    private String id;

    /**
     * 文章分类ID
     */
    private String categoryId;

    /**
     * 文章分类名称
     */
    private String categoryName;

    /**
     * 文章封面
     */
    private String cover;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 是否置顶
     */
    private Boolean top;

    /**
     * 文章创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 文章更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime updateTime;


}
