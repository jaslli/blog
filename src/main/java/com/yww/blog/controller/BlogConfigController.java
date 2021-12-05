package com.yww.blog.controller;

import com.yww.blog.service.BlogConfigService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   博客信息   前端控制器
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 15:03
 **/
@RestController
@CrossOrigin
@Api(tags = "博客配置信息接口")
@RequestMapping("/blog")
public class BlogConfigController {

    private final BlogConfigService blogConfigService;
    @Autowired
    public BlogConfigController(BlogConfigService blogConfigService) {
        this.blogConfigService = blogConfigService;
    }

    @ApiOperation("初始化博客的配置信息")
    @GetMapping("init")
    public Result initConfig() {
        return Result.success(blogConfigService.initConfig());
    }

    @ApiOperation("获取博客配置信息")
    @GetMapping("getInfo")
    public Result getInfo() {
        return Result.success(blogConfigService.getInfo());
    }

}
