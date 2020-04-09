package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Teaching;
import cuit.hyl.graduation.project_ui.service.TeachingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 教学活动(Teaching)表控制层
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
@Api(tags = "教学活动")
@RestController
@RequestMapping("api/ui/teaching")
public class TeachingController {
    /**
     * 服务对象
     */
    @Resource
    private TeachingService teachingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过用户id查询教学活动页面初始化消息")
    @PostMapping("initInfo/{id}")
    public ResponseResult initInfo(@PathVariable Long id) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();



        result.setData(map);

        return result;
    }

}