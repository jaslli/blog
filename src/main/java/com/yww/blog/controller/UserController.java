package com.yww.blog.controller;

import com.yww.blog.service.IUserService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  用户  前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-03
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ApiOperation("通过用户名获取用户信息")
    @ApiImplicitParam(name = "userName", value = "用户名",required = true)
    @GetMapping("/getUserInfo/{userName}")
    public Result getUserInfo(@PathVariable("userName") String userName) {
        return Result.success(userService.getByUsername(userName));
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/getUserList")
    public Result getUserList() {
        return Result.success(userService.getUserList());
    }

}

