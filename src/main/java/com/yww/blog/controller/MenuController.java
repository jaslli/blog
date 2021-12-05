package com.yww.blog.controller;


import com.yww.blog.service.IMenuService;
import com.yww.blog.util.Result;
import com.yww.blog.vo.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@RestController
@CrossOrigin
@Api(tags = "菜单或按钮权限接口")
@RequestMapping("/menu")
public class MenuController {

    private final IMenuService service;
    @Autowired
    public MenuController(IMenuService service) {
        this.service = service;
    }

    @ApiOperation("后台获取菜单数据")
    @ApiImplicitParam(name = "userId", value = "用户ID",required = true)
    @GetMapping("/getMenuList/{userId}")
    public Result getMenuList(@PathVariable("userId") String userId) {
        return Result.success(service.getMenus(userId));
    }

    @ApiOperation("添加或修改菜单")
    @ApiImplicitParam(name = "menuVO", value = "菜单实体数据",required = true)
    @PostMapping("save")
    public Result saveArticleContent(@RequestBody MenuVO menuVO) {
        return Result.success(service.saveOrUpdate(menuVO));
    }

}

