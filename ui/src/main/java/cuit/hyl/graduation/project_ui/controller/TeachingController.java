package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Teaching;
import cuit.hyl.graduation.project_ui.entity.TeachingClass;
import cuit.hyl.graduation.project_ui.entity.TeachingItem;
import cuit.hyl.graduation.project_ui.service.TeachingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教学活动(Teaching)表控制层
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
@Slf4j
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

        List<Teaching> teachings = this.teachingService.initTeach(id);
        if (teachings.size() != 0){
        Teaching teach = teachings.get(0);
            //教学研究
            List<TeachingItem> research = this.teachingService.initTeachItem(1, teach.getResearch());
            //教学资源
            List<TeachingItem> resources = this.teachingService.initTeachItem(2, teach.getResources());
            //教学成果
            List<TeachingItem> achievements = this.teachingService.initTeachItem(3, teach .getAchievements());
            //授课信息
            //本科生
            List<TeachingClass> undergraduate = this.teachingService.initTeachClass(1, teach.getClassInfo());
            //研究生
            List<TeachingClass> postgraduate = this.teachingService.initTeachClass(2, teach.getClassInfo());

            map.put("research", research);
            map.put("resources", resources);
            map.put("achievements", achievements);
            map.put("undergraduate", undergraduate);
            map.put("postgraduate", postgraduate);
        }else{
            result.setMessage("目前没有教学活动信息！");
        }


        result.setData(map);

        return result;
    }

}