package com.yww.blog.service.impl;

import cn.hutool.core.date.DateUtil;
import com.yww.blog.constant.RedisConstant;
import com.yww.blog.service.BlogConfigService;
import com.yww.blog.util.RedisUtil;
import com.yww.blog.vo.BlogConfigVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *     博客配置的实现类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 15:05
 **/
@Service
public class BlogConfigServiceImpl implements BlogConfigService {

    @Resource
    private RedisUtil util;

    @Override
    public BlogConfigVO initConfig() {
        BlogConfigVO blogConfigVo = BlogConfigVO.builder()
                .title("Yw的博客")
                .subtitle("yww")
                .avatar("https://img.yww52.com/avatar.jpg")
                .name("Yw")
                .description("永远相信美好的事情即将发生")
                .notice("欢迎来到我的博客!")
                .lovely("https://img.yww52.com/lovely.jpg")
                .icp("桂ICP备20005765号")
                .homeBanner("https://img.yww52.com/wallpaper.jpg")
                .archivesBanner("https://img.yww52.com/archives_top_img.jpg")
                .categoriesBanner("https://img.yww52.com/categories_top_img.jpg")
                .linkBanner("https://img.yww52.com/link_top_img.jpg")
                .aboutBanner("https://img.yww52.com/about_top_img.jpg")
                .createTime(DateUtil.parse("2018-9-10"))
                .build();
        util.set(RedisConstant.TITLE, blogConfigVo.getTitle());
        util.set(RedisConstant.SUBTITLE, blogConfigVo.getSubtitle());
        util.set(RedisConstant.AVATAR, blogConfigVo.getAvatar());
        util.set(RedisConstant.NAME, blogConfigVo.getName());
        util.set(RedisConstant.DESCRIPTION, blogConfigVo.getDescription());
        util.set(RedisConstant.NOTICE, blogConfigVo.getNotice());
        util.set(RedisConstant.LOVELY, blogConfigVo.getLovely());
        util.set(RedisConstant.ICP, blogConfigVo.getIcp());
        util.set(RedisConstant.HOME_BANNER, blogConfigVo.getHomeBanner());
        util.set(RedisConstant.ARCHIVES_BANNER, blogConfigVo.getArchivesBanner());
        util.set(RedisConstant.CATEGORIES_BANNER, blogConfigVo.getCategoriesBanner());
        util.set(RedisConstant.LINK_BANNER, blogConfigVo.getLinkBanner());
        util.set(RedisConstant.ABOUT_BANNER, blogConfigVo.getAboutBanner());
        util.set(RedisConstant.CREATE_TIME, blogConfigVo.getCreateTime().toString());
        return blogConfigVo;
    }

    @Override
    public BlogConfigVO getInfo() {
        return BlogConfigVO.builder()
                .title(util.get(RedisConstant.TITLE))
                .subtitle(util.get(RedisConstant.SUBTITLE))
                .avatar(util.get(RedisConstant.AVATAR))
                .name(util.get(RedisConstant.NAME))
                .description(util.get(RedisConstant.DESCRIPTION))
                .notice(util.get(RedisConstant.NOTICE))
                .lovely(util.get(RedisConstant.LOVELY))
                .icp(util.get(RedisConstant.ICP))
                .homeBanner(util.get(RedisConstant.HOME_BANNER))
                .archivesBanner(util.get(RedisConstant.ARCHIVES_BANNER))
                .categoriesBanner(util.get(RedisConstant.CATEGORIES_BANNER))
                .linkBanner(util.get(RedisConstant.LINK_BANNER))
                .aboutBanner(util.get(RedisConstant.ABOUT_BANNER))
                .createTime(DateUtil.parse(util.get(RedisConstant.CREATE_TIME)))
                .build();
    }
}
