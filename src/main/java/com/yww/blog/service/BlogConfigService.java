package com.yww.blog.service;

import com.yww.blog.vo.BlogConfigVO;

/**
 * <p>
 *     博客配置的服务类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 15:05
 **/
public interface BlogConfigService {

    /**
     *  重置博客配置信息
     * @return BlogConfigVo
     */
    BlogConfigVO initConfig();

    /**
     * 获取博客配置信息
     * @return BlogConfigVo
     */
    BlogConfigVO getInfo();

}
