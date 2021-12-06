package com.yww.blog.controller;


import com.yww.blog.entity.Category;
import com.yww.blog.service.ICategoryService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  分类  前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@RestController
@CrossOrigin
@Api(tags = "分类接口")
@RequestMapping("/category")
public class CategoryController {

    private final ICategoryService service;
    @Autowired
    public CategoryController(ICategoryService service) {
        this.service = service;
    }

    @ApiOperation("查询所有分类数据，包括每个分类的文章数")
    @GetMapping("selelctAll")
    public Result selectAll() {
        return Result.success(service.selectAll());
    }

    @ApiOperation("查询所有分类数据,包括每个分类的文章数(包含文章数为0的不显示)")
    @GetMapping("listAll")
    public Result listAll() {
        return Result.success(service.listAll());
    }

    @ApiOperation("新增分类")
    @PostMapping("save")
    public Result saveCategory(@RequestBody Category category) {
        return Result.success(service.save(category));
    }

    @ApiOperation("根据分类ID查询分类数据")
    @ApiImplicitParam(name = "id", value = "分类数据Id",required = true)
    @GetMapping("getById/{id}")
    public Result selectById(@PathVariable("id") String id) {
        return Result.success(service.getById(id));
    }

}

