package com.yww.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 *     博客配置显示类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 14:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogConfigVO {

    /**
     *  博客主标题
     */
    private String title;

    /**
     *  博客副标题
     */
    private String subtitle;

    /**
     *  博主头像
     */
    private String avatar;

    /**
     *  博主名称
     */
    private String name;

    /**
     *  博主描述
     */
    private String description;

    /**
     *  博客公告
     */
    private String notice;

    /**
     *  博客展示栏
     */
    private String lovely;

    /**
     *  博客创建时间
     */
    private Date createTime;

    /**
     *  网站备案号
     */
    private String icp;

    /**
     *  主页Banner
     */
    private String homeBanner;

    /**
     *  归档页Banner
     */
    private String archivesBanner;

    /**
     *  分类页Banner
     */
    private String categoriesBanner;

    /**
     *  友链页Banner
     */
    private String linkBanner;

    /**
     *  关于页Banner
     */
    private String aboutBanner;
}
