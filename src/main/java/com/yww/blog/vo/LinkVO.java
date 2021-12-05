package com.yww.blog.vo;

import com.yww.blog.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *     友链显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/23 22:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkVO {

    /**
     * 分组ID
     */
    private String id;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组描述
     */
    private String description;

    /**
     * 友链列表
     */
    private List<Link> children;
}
