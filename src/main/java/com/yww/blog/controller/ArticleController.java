package com.yww.blog.controller;


import com.yww.blog.entity.Article;
import com.yww.blog.service.IArticleService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  文章  前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-21
 */
@RestController
@CrossOrigin
@Api(tags = "文章接口")
@RequestMapping("/article")
public class ArticleController {

    private final IArticleService service;
    @Autowired
    public ArticleController(IArticleService service) {
        this.service = service;
    }

    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "文章数据ID",required = true)
    @GetMapping("getById/{id}")
    public Result selectById(@PathVariable("id") String id) {
        return Result.success(service.selectById(id));
    }

    @ApiOperation("分页查询")
    @GetMapping("pageselect/{current}/{limit}")
    public Result pageselect(
            @ApiParam(name = "current", value = "当前页码", required = true)
            @PathVariable("current") long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") long limit
    ) {
        return Result.success(service.pageselect(current, limit));
    }

    @ApiOperation("根据分类ID进行的分页查询")
    @GetMapping("pageselect/{current}/{limit}/{categoryId}")
    public Result pageselect(
            @ApiParam(name = "current", value = "当前页码", required = true)
            @PathVariable("current") long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") long limit,
            @ApiParam(name = "categoryId", value = "每页记录数", required = false)
            @PathVariable("categoryId") String categoryId
    ) {
        return Result.success(service.pageselect(current, limit, categoryId));
    }

    @ApiOperation("添加文章")
    @ApiImplicitParam(name = "article", value = "文章实体类",required = true)
    @PostMapping("add")
    public Result addArticle(@RequestBody Article article) {
        return Result.success(service.save(article));
    }

}

