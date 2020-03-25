package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础信息(BasicInfo)表控制层
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
@Api(tags = "基础信息")
@RestController
@RequestMapping("api/ui/basicInfo")
public class BasicInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BasicInfoService basicInfoService;

    /**
     * 通过用户id查询单条数据
     */
    @ApiOperation("通过用户id查询单条数据")
    @GetMapping("queryByPeopleId/{id}")
    public ResponseResult queryByPeopleId(@PathVariable Integer id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.basicInfoService.queryByPeopleId(id).get(0));
    }

    @ApiOperation("通过用户id查询初始化数据")
    @GetMapping("queryInitInfo/{id}")
    public ResponseResult queryInitInfo(@PathVariable Integer id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.basicInfoService.queryInitInfo(id).get(0));
    }

}