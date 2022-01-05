package com.yww.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yww.blog.entity.Article;
import com.yww.blog.util.Result;
import com.yww.blog.vo.ArticlePageVO;
import com.yww.blog.vo.ArticleVO;

/**
 * <p>
 *  文章服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-21
 */
public interface IArticleService extends IService<Article> {

    /**
     * 分页获取数据
     * @param current   当前页码
     * @param limit     每页记录数
     * @return  ArticlePageVo
     */
    ArticlePageVO pageselect(long current, long limit);

    /**
     * 根据分类ID进行的查询
     * @param current   当前页码
     * @param limit     每页记录数
     * @param categoryId    分类ID
     * @return ArticlePageVo
     */
    ArticlePageVO pageselect(long current, long limit, String categoryId);

    /**
     * 根据文章ID查询文章信息
     * @param id 文章ID
     * @return  ArticleVO
     */
    ArticleVO selectById(String id);

    /**
     * 根据分类ID获取文章总数
     * @param categoryId 分类ID
     * @return 文章总数
     */
    Integer getCount(String categoryId);

    /**
     * 根据ID删除文章和对应得文章内容
     * @param id    文章ID
     * @return      删除结果
     */
    Result delete(String id);
}
