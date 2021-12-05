package com.yww.blog.vo;

import com.yww.blog.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *     文章分页数据的显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 22:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticlePageVO {

    /**
     * 文章列表
     */
    private List<ArticleVO> list;

    /**
     * 文章列表
     */
    private List<Article> arList;

    /**
     * 文章总数目
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pages;

}
