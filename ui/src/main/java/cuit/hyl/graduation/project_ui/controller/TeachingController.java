package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.entity.vo.UserVo;
import cuit.hyl.graduation.project_ui.service.TeachingService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
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

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过用户id查询教学活动页面初始化消息")
    @PostMapping("initInfo/{version}")
    public ResponseResult initInfo(@PathVariable Long version) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        List<Teaching> teachings = this.teachingService.initTeach(id, version);
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

            map.put("teach", teach);
            map.put("research", research);
            map.put("resources", resources);
            map.put("achievements", achievements);
            map.put("undergraduate", undergraduate);
            map.put("postgraduate", postgraduate);
            result.setData(map);
        }else{
            Teaching teaching = new Teaching();
            teaching.setId(idWorker.nextId());
            teaching.setAchievements(idWorker.nextId());
            teaching.setClassInfo(idWorker.nextId());
            teaching.setPeopleId(id);
            teaching.setResearch(idWorker.nextId());
            teaching.setResources(idWorker.nextId());
            this.teachingService.insertTeach(teaching);
            result.setMessage("目前没有教学活动信息！");
        }

        return result;
    }

    @ApiOperation("新增教学活动信息")
    @PostMapping("insertTeach")
    public ResponseResult insertTeach() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult result = new ResponseResult();
        Teaching teaching = new Teaching();
        teaching.setId(idWorker.nextId());
        teaching.setAchievements(idWorker.nextId());
        teaching.setClassInfo(idWorker.nextId());
        teaching.setPeopleId(id);
        teaching.setResearch(idWorker.nextId());
        teaching.setResources(idWorker.nextId());
        this.teachingService.insertTeach(teaching);
        result.setMessage("更新家庭基础信息！");
        return result;
    }
    @ApiOperation("新增教学活动")
    @PostMapping("insertTeachItem/{id}")
    public ResponseResult insertTeachItem(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("parentId", id);
        int i = this.teachingService.insertTeachItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("更新教学活动")
    @PostMapping("updateTeachItem")
    public ResponseResult updateTeachItem(@RequestBody(required = false) JSONObject params) {
        int i = this.teachingService.updateTeachItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("删除教学活动")
    @DeleteMapping("deleteTeachItem/{id}")
    public ResponseResult deleteTeachItem(@PathVariable Long id) {
        int i = this.teachingService.deleteTeachItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }
    @ApiOperation("新增教学课程活动")
    @PostMapping("insertTeachClass/{id}")
    public ResponseResult insertTeachClass(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("classInfoId", id);
        int i = this.teachingService.insertTeachClass(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("更新教学课程活动")
    @PostMapping("updateTeachClass")
    public ResponseResult updateTeachClass(@RequestBody(required = false) JSONObject params) {
        int i = this.teachingService.updateTeachClass(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("删除教学课程活动")
    @DeleteMapping("deleteTeachClass/{id}")
    public ResponseResult deleteTeachClass(@PathVariable Long id) {
        int i = this.teachingService.deleteTeachClass(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }

}