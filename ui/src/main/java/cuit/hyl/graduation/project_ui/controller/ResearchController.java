package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.service.ResearchService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
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

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);


    @ApiOperation("通过用户id查询科研活动页面初始化消息")
    @PostMapping("initInfo/{id}/{version}")
    public ResponseResult initInfo(@PathVariable Long id, @PathVariable Long version) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        List<Research> researchList = researchService.initInfo(id, version);
        if (researchList.size() != 0){
            Research research = researchList.get(0);
            List<ResearchItem> researchAreas = researchService.queryItems(research.getResearchAreas() , 1);
            List<ResearchItem> thesisResults = researchService.queryItems(research.getThesisResults() , 2);
            List<ResearchItem> patent = researchService.queryItems(research.getPatent() , 3);
            List<ResearchItem> achievements = researchService.queryItems(research.getAchievements() , 4);
            List<ResearchItem> researchProjects = researchService.queryItems(research.getResearchProjects() , 5);
            List<ResearchItem> researchTeam = researchService.queryItems(research.getResearchTeam() , 6);

            map.put("research", research);
            map.put("researchAreas", researchAreas);
            map.put("thesisResults", thesisResults);
            map.put("patent", patent);
            map.put("achievements", achievements);
            map.put("researchProjects", researchProjects);
            map.put("researchTeam", researchTeam);
        }else {
            Research research = new Research();
            research.setId(idWorker.nextId());
            research.setAchievements(idWorker.nextId());
            research.setPatent(idWorker.nextId());
            research.setResearchAreas(idWorker.nextId());
            research.setResearchProjects(idWorker.nextId());
            research.setResearchTeam(idWorker.nextId());
            research.setThesisResults(idWorker.nextId());
            research.setPeopleId(id);
            this.researchService.insertResearch(research);
            result.setMessage("未设置教师科研活动信息");
        }

        result.setData(map);

        return result;
    }

    @ApiOperation("新增科研活动")
    @PostMapping("insertResearchItem/{id}")
    public ResponseResult insertResearchItem(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("parentId", id);
        int i = this.researchService.insertResearchItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("更新科研活动")
    @PostMapping("updateResearchItem")
    public ResponseResult updateResearchItem(@RequestBody(required = false) JSONObject params) {
        int i = this.researchService.updateResearchItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("删除科研活动")
    @DeleteMapping("deleteResearchItem/{id}")
    public ResponseResult deleteResearchItem(@PathVariable Long id) {
        int i = this.researchService.deleteResearchItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }

}