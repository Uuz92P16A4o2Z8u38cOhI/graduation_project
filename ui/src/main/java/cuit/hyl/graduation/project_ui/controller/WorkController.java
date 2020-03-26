package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Work;
import cuit.hyl.graduation.project_ui.service.WorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 工作情况(Work)表控制层
 *
 * @author makejava
 * @since 2020-03-25 19:38:13
 */
@Api(tags = "工作信息")
@RestController
@RequestMapping("api/ui/work")
public class WorkController {
    /**
     * 服务对象
     */
    @Resource
    private WorkService workService;

    @ApiOperation("通过用户id查询工作页面初始化消息")
    @GetMapping("initInfo/{id}")
    public ResponseResult queryInitInfo(@PathVariable Integer id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.workService.queryInitInfo(id));
    }

    @ApiOperation("通过用户id 版本号查询工作消息")
    @GetMapping("version/{version}/{id}")
    public ResponseResult queryByVersion(@PathVariable Integer id,@PathVariable Integer version) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.workService.queryByVersion(id,version));
    }

    @ApiOperation("通过用户id查询工作所有版本")
    @GetMapping("allVersion/{id}")
    public ResponseResult queryAllVersion(@PathVariable Integer id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.workService.queryAllVersion(id));
    }

    @ApiOperation("通过用户id查询用户所有工作")
    @GetMapping("all/{id}")
    public ResponseResult queryAll(@PathVariable Integer id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.workService.queryAll(id));
    }

}