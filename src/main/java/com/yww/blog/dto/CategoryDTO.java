package com.yww.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *     分类数据的传输对象
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/22 22:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    /**
     * 数据ID
     */
    private String id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 该分类所包含的文章数量
     */
    private Integer count;


    /**
     * 分类创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 子分类的对象
     */
    private List<CategoryDTO> children;

}
