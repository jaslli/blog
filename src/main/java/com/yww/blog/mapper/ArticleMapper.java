package com.yww.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yww.blog.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  文章类的 Mapper 接口
 * </p>
 *
 * @author yww
 * @since 2021-11-21
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}
