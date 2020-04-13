package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.AwardsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 获奖信息(Awards)表控制层
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
@Api(tags = "获奖情况")
@RestController
@RequestMapping("api/ui/awards")
public class AwardsController {
    /**
     * 服务对象
     */
    @Resource
    private AwardsService awardsService;


    @ApiOperation("通过用户id查询获奖情况页面初始化消息")
    @PostMapping("initInfo/{id}")
    public ResponseResult initInfo(@PathVariable Long id) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();


        result.setData(map);

        return result;
    }
}