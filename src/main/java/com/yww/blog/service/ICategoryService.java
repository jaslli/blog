package com.yww.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yww.blog.entity.Category;
import com.yww.blog.vo.CategoryPageVO;

/**
 * <p>
 *  分类  服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
public interface ICategoryService extends IService<Category> {

    /**
     *  获取所有分类数据（不包括包含文章数为0的分类）
     * @return CategoryVO
     */
    CategoryPageVO listAll();

    /**
     * 获取所有分类数据
     * @return CategoryPageVO
     */
    CategoryPageVO selectAll();
}
