package com.yww.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yww.blog.entity.Menu;
import com.yww.blog.mapper.MenuMapper;
import com.yww.blog.mapper.RoleMenuMapper;
import com.yww.blog.service.IMenuService;
import com.yww.blog.service.IRoleService;
import com.yww.blog.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    private final IRoleService roleService;
    private final RoleMenuMapper roleMenuMapper;
    @Autowired
    public MenuServiceImpl(IRoleService roleService, RoleMenuMapper roleMenuMapper) {
        this.roleService = roleService;
        this.roleMenuMapper = roleMenuMapper;
    }

    @Override
    public List<MenuVO> getMenus(String userId) {
        String roleId = roleService.getRoleIdByUserId(userId);
        List<String> menuIds = roleMenuMapper.getMenuIdsByRoleId(roleId);
        List<Menu> list = baseMapper.selectBatchIds(menuIds);
        List<Menu> menus = list.stream()
                .sorted(Comparator.comparing(Menu::getSort))
                .collect(Collectors.toList());
        List<MenuVO> res = new ArrayList<>();
        for (Menu menu : menus) {
            if (!StrUtil.isBlankOrUndefined(menu.getParentId())) {
                continue;
            }
            MenuVO menuVO = transformVo(menu);
            menuVO.setChildren(new ArrayList<>());
            for (Menu temp : menus) {
                if (StrUtil.isBlankOrUndefined(temp.getParentId())) {
                    continue;
                }
                if (temp.getParentId().equals(menuVO.getId())) {
                    menuVO.getChildren().add(transformVo(temp));
                }
            }
            res.add(menuVO);
        }
        return res;
    }

    private MenuVO transformVo(Menu menu) {
        MenuVO menuVO = new MenuVO();
        BeanUtil.copyProperties(menu, menuVO);
        return menuVO;
    }

    @Override
    public List<Menu> getMenusByUserId(String userId) {
        String roleId = roleService.getRoleIdByUserId(userId);
        List<String> menuIds = roleMenuMapper.getMenuIdsByRoleId(roleId);
        return baseMapper.selectBatchIds(menuIds);
    }

    @Override
    public Boolean saveOrUpdate(MenuVO menuVO) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuVO,menu);
        if (StrUtil.isBlankOrUndefined(menu.getId())) {
            baseMapper.insert(menu);
        } else {
            baseMapper.updateById(menu);
        }
        return true;
    }

}
