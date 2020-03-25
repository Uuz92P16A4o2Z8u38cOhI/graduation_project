package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.TeachUnit;
import cuit.hyl.graduation.project_ui.service.TeachUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TeachUnit)表控制层
 *
 * @author makejava
 * @since 2020-02-04 19:48:03
 */
@Api(tags = "教学单位")
@RestController
@RequestMapping("api/ui/teachUnit")
public class TeachUnitController {

    @Resource
    private TeachUnitService teachUnitService;

    @ApiOperation("所有教学单位")
    @GetMapping("queryAll/{schoolCode}")
    public ResponseResult queryAll(@PathVariable Integer schoolCode) {
        if(schoolCode == null)
            schoolCode = 10621;

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询所有教学单位", this.teachUnitService.queryAll(schoolCode));
    }

}