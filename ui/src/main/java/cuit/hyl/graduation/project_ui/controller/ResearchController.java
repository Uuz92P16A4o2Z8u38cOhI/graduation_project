package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.service.ResearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科研活动(Research)表控制层
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
@Slf4j
@Api(tags = "科研活动")
@RestController
@RequestMapping("api/ui/research")
public class ResearchController {
    /**
     * 服务对象
     */
    @Resource
    private ResearchService researchService;


    @ApiOperation("通过用户id查询科研活动页面初始化消息")
    @PostMapping("initInfo/{id}")
    public ResponseResult initInfo(@PathVariable Long id) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        List<Research> researchList = researchService.initInfo(id);
        if (researchList.size() != 0){
            Research research = researchList.get(0);
            List<ResearchItem> researchAreas = researchService.queryItems(research.getResearchAreas() , 1);
            List<ResearchItem> thesisResults = researchService.queryItems(research.getThesisResults() , 2);
            List<ResearchItem> patent = researchService.queryItems(research.getPatent() , 3);
            List<ResearchItem> achievements = researchService.queryItems(research.getAchievements() , 4);
            List<ResearchItem> researchProjects = researchService.queryItems(research.getResearchProjects() , 5);
            List<ResearchItem> researchTeam = researchService.queryItems(research.getResearchTeam() , 6);

            map.put("researchAreas", researchAreas);
            map.put("thesisResults", thesisResults);
            map.put("patent", patent);
            map.put("achievements", achievements);
            map.put("researchProjects", researchProjects);
            map.put("researchTeam", researchTeam);
        }else {
            result.setMessage("未设置教师科研活动信息");
        }

        result.setData(map);

        return result;
    }

}