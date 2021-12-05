package com.yww.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yww.blog.entity.Link;
import com.yww.blog.vo.LinkVO;

import java.util.List;

/**
 * <p>
 *  友链  服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
public interface ILinkService extends IService<Link> {

    /**
     * 查询所有友链信息
     * @return List<LinkVO>
     */
    List<LinkVO> listAll();

}
