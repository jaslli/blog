package com.yww.blog.vo;

import com.yww.blog.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *     分页分类数据显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/22 22:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryPageVO {

    /**
     * 分类数据列表
     */
    private List<CategoryDTO> list;

    /**
     * 分类总数
     */
    private Integer total;

}
