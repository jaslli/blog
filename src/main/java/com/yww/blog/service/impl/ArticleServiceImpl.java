package com.yww.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.entity.Article;
import com.yww.blog.mapper.ArticleMapper;
import com.yww.blog.service.IArticleService;
import com.yww.blog.service.ICategoryService;
import com.yww.blog.vo.ArticlePageVO;
import com.yww.blog.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  文章服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-21
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    ICategoryService categoryService;

    /**
     * TODO 是否用优化？
     */
    @Override
    public ArticlePageVO pageselect(long current, long limit) {
        Page<Article> page = new Page<>(current, limit, true);
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        List<ArticleVO> list = new ArrayList<>();
        wrapper.eq("is_publish",1);
        wrapper.orderByDesc("is_top");
        baseMapper.selectPage(page, wrapper);
        for (Article article : page.getRecords()) {
            ArticleVO temp = new ArticleVO();
            BeanUtil.copyProperties(article, temp);
            temp.setCategoryName(categoryService.getById(article.getCategoryId()).getName());
            list.add(temp);
        }
        return ArticlePageVO.builder()
                .list(list)
                .total(page.getTotal())
                .pages(page.getPages())
                .build();
    }

    @Override
    public ArticlePageVO pageselect(long current, long limit, String categoryId) {
        Page<Article> page = new Page<>(current, limit, true);
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("is_publish",1);
        if (categoryId != null && StrUtil.isBlank(categoryId)) {
            wrapper.eq("category_id",categoryId);
        }
        baseMapper.selectPage(page, wrapper);
        return ArticlePageVO.builder()
                .arList(page.getRecords())
                .total(page.getTotal())
                .pages(page.getPages())
                .build();
    }

    @Override
    public ArticleVO selectById(String id) {
        Article temp = baseMapper.selectById(id);
        ArticleVO articleVO = new ArticleVO();
        BeanUtil.copyProperties(temp, articleVO);
        articleVO.setCategoryName(categoryService.getById(temp.getCategoryId()).getName());
        return articleVO;
    }

    @Override
    public Integer getCount(String categoryId) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",categoryId);
        return baseMapper.selectList(wrapper).size();
    }

}
