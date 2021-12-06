package com.yww.blog.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.entity.Link;
import com.yww.blog.mapper.LinkMapper;
import com.yww.blog.service.ILinkService;
import com.yww.blog.vo.LinkVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  友链  服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {

    @Override
    public List<LinkVO> listAll() {
        List<Link> linkList = baseMapper
                .selectList(new QueryWrapper<Link>().orderByAsc("sort"));
        List<LinkVO> list = new ArrayList<>();
        for (Link link : linkList) {
            if (!link.getType()) {
                LinkVO temp = LinkVO.builder()
                        .id(link.getId())
                        .name(link.getName())
                        .description(link.getDescription())
                        .children(new ArrayList<>())
                        .build();
                for (Link item : linkList) {
                    if (StrUtil.isBlankOrUndefined(item.getGroupId())) {
                        continue;
                    }
                    if (item.getGroupId().equals(link.getId())) {
                        temp.getChildren().add(item);
                    }
                }
                list.add(temp);
            }
        }
        return list;
    }

}
