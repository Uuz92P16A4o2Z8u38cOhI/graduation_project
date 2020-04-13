package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.EducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 教育经历(Education)表控制层
 *
 * @author makejava
 * @since 2020-04-02 20:22:55
 */
@Api(tags = "受教育情况")
@RestController
@RequestMapping("api/ui/education")
public class EducationController {
    /**
     * 服务对象
     */
    @Resource
    private EducationService educationService;

    @ApiOperation("通过用户id查询受教育页面初始化消息")
    @GetMapping("initInfo/{id}")
    public ResponseResult queryInitInfo(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.educationService.queryInitInfo(id));
    }

    @ApiOperation("通过用户id 版本号查询受教育消息")
    @GetMapping("version/{version}/{id}")
    public ResponseResult queryByVersion(@PathVariable Long id,@PathVariable Integer version) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询", this.educationService.queryByVersion(id,version));
    }

    @ApiOperation("通过用户id查询受教育所有版本")
    @GetMapping("allVersion/{id}")
    public ResponseResult queryAllVersion(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询受教育所有版本", this.educationService.queryAllVersion(id));
    }

    @ApiOperation("通过用户id查询用户所有受教育情况")
    @GetMapping("all/{id}")
    public ResponseResult queryAll(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询用户所有受教育情况", this.educationService.queryAll(id));
    }





}