package com.yww.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.dto.CategoryDTO;
import com.yww.blog.entity.Category;
import com.yww.blog.mapper.CategoryMapper;
import com.yww.blog.service.IArticleService;
import com.yww.blog.service.ICategoryService;
import com.yww.blog.vo.CategoryPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    IArticleService articleService;

    @Override
    public CategoryPageVO listAll() {
        List<Category> list = baseMapper.selectList(
                new QueryWrapper<Category>().orderByDesc("sort")
        );
        List<CategoryDTO> categoryList = new ArrayList<>();
        int total = 0;
        for (Category category : list) {
            if (StrUtil.hasBlank(category.getParentId())) {
                CategoryDTO categoryDTO = CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .count(articleService.getCount(category.getId()))
                        .children(new ArrayList<>())
                        .build();
                if (categoryDTO.getCount() != 0) {
                    categoryList.add(categoryDTO);
                    continue;
                }
                for (Category c : list) {
                    if (categoryDTO.getId().equals(c.getParentId())) {
                        CategoryDTO temp = new CategoryDTO();
                        BeanUtil.copyProperties(c, temp);
                        int count = articleService.getCount(temp.getId());
                        temp.setCount(count);
                        categoryDTO.setCount(categoryDTO.getCount() + count);
                        if (temp.getCount() != 0) {
                            total++;
                            categoryDTO.getChildren().add(temp);
                        }
                    }
                }
                if (categoryDTO.getCount() != 0) {
                    total++;
                    categoryList.add(categoryDTO);
                }
            }
        }
        return CategoryPageVO.builder().list(categoryList).total(total).build();
    }

    @Override
    public CategoryPageVO selectAll() {
        List<Category> list = baseMapper.selectList(null);
        List<CategoryDTO> categoryList = new ArrayList<>();
        for (Category category : list) {
            if (StrUtil.hasBlank(category.getParentId())) {
                CategoryDTO categoryDTO = CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .createTime(category.getCreateTime())
                        .count(articleService.getCount(category.getId()))
                        .children(new ArrayList<>())
                        .build();
                if (categoryDTO.getCount() != 0) {
                    categoryList.add(categoryDTO);
                    continue;
                }
                for (Category c : list) {
                    if (categoryDTO.getId().equals(c.getParentId())) {
                        CategoryDTO temp = new CategoryDTO();
                        BeanUtil.copyProperties(c, temp);
                        int count = articleService.getCount(temp.getId());
                        temp.setCount(count);
                        categoryDTO.setCount(categoryDTO.getCount() + count);
                        categoryDTO.getChildren().add(temp);
                    }
                }
                categoryList.add(categoryDTO);
            }
        }
        return CategoryPageVO.builder().list(categoryList).build();
    }

}
