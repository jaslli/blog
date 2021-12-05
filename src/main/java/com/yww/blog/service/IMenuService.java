package com.yww.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yww.blog.entity.Menu;
import com.yww.blog.vo.MenuVO;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户ID获取菜单数据
     * @param userId 用户ID
     * @return  菜单数据
     */
    List<MenuVO> getMenus(String userId);

    /**
     * 根据用户ID查询菜单（按钮）列表
     * @param userId    用户ID
     * @return          菜单（按钮）列表
     */
    List<Menu> getMenusByUserId(String userId);

    /**
     * 添加或修改菜单数据
     * @param menuVO 菜单显示类
     * @return  true Or false
     */
    Boolean saveOrUpdate(MenuVO menuVO);

}
