package com.yww.blog.controller;


import com.yww.blog.entity.Link;
import com.yww.blog.service.ILinkService;
import com.yww.blog.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  友链  前端控制器
 * </p>
 *
 * @author yww
 * @since 2021-11-23
 */
@RestController
@CrossOrigin
@Api(tags = "友链接口")
@RequestMapping("/link")
public class LinkController {

    private final ILinkService service;
    @Autowired
    public LinkController(ILinkService service) {
        this.service = service;
    }

    @ApiOperation("查询所有友链数据(前台)")
    @GetMapping("listAll")
    public Result listAll() {
        return Result.success(service.listAll());
    }

    @ApiOperation("添加友链数据")
    @ApiImplicitParam(name = "link", value = "友链实体类",required = true)
    @PostMapping("save")
    public Result save(@RequestBody Link link) {
        return Result.success(service.save(link));
    }

    @ApiOperation("添加友链数据")
    @ApiImplicitParam(name = "id", value = "友链ID",required = true)
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id")String id) {
        return Result.success(service.removeById(id));
    }

}

