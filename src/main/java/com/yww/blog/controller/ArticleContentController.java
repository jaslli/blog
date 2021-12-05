package com.yww.blog.controller;


import com.yww.blog.entity.ArticleContent;
import com.yww.blog.service.IArticleContentService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  文章内容    前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-26
 */
@RestController
@CrossOrigin
@Api(tags = "文章内容接口")
@RequestMapping("/article-content")
public class ArticleContentController {

    private final IArticleContentService service;
    @Autowired
    public ArticleContentController(IArticleContentService service) {
        this.service = service;
    }

    @ApiOperation("根据文章内容ID查询文章内容")
    @ApiImplicitParam(name = "id", value = "文章内容ID",required = true)
    @GetMapping("getById/{id}")
    public Result selectById(@PathVariable("id") String id) {
        return Result.success(service.getById(id));
    }

    @ApiOperation("添加文章内容")
    @ApiImplicitParam(name = "content", value = "文章内容",required = true)
    @PostMapping("save")
    public Result saveArticleContent(@RequestBody ArticleContent content) {
        return Result.success(service.save(content));
    }

}

