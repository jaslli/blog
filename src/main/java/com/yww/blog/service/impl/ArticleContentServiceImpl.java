package com.yww.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.entity.ArticleContent;
import com.yww.blog.mapper.ArticleContentMapper;
import com.yww.blog.service.IArticleContentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  文章内容服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-26
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService {

}
