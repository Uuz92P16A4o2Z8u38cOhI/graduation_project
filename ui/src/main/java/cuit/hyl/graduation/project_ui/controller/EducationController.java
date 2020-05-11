package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Version;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import cuit.hyl.graduation.project_ui.service.EducationService;
import cuit.hyl.graduation.project_ui.service.VersionService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 教育经历(Education)表控制层
 *
 * @author makejava
 * @since 2020-04-02 20:22:55
 */
@Slf4j
@Api(tags = "受教育情况")
@RestController
@RequestMapping("api/ui/education")
public class EducationController {
    /**
     * 服务对象
     */
    @Resource
    private EducationService educationService;
    @Resource
    private VersionService versionService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation("通过用户id查询受教育页面初始化消息")
    @GetMapping("initInfo/{id}/{version}")
    public ResponseResult queryInitInfo(@PathVariable Long id, @PathVariable Long version) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        List<Education> educationList = this.educationService.queryInitInfo(id,version);
        if (educationList.size() == 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"未设置教师受教育情况");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", educationList);
        }
//        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.educationService.queryInitInfo(id));
    }

    @ApiOperation("用户新增受教育情况")
    @PostMapping("insertItem/{id}")
    public ResponseResult insertItem(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        params.put("id", idWorker.nextId());
        params.put("peopleId", id);
        int i = this.educationService.insertItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("用户更新受教育情况")
    @PostMapping("updateItem")
    public ResponseResult updateItem(@RequestBody(required = false) JSONObject params) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        int i = this.educationService.updateItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("用户删除受教育情况")
    @DeleteMapping("deleteItem/{id}")
    public ResponseResult deleteItem(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        int i = this.educationService.deleteItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }



    @ApiOperation("通过用户id 版本号查询受教育消息")
    @GetMapping("version/{version}/{id}")
    public ResponseResult queryByVersion(@PathVariable Long id,@PathVariable String version) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询", this.educationService.queryByVersion(id,version));
    }

    @ApiOperation("通过用户id查询受教育所有版本")
    @GetMapping("allVersion/{id}")
    public ResponseResult queryAllVersion(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        List<Versions> versions = this.educationService.queryAllVersion(id);
        List<Version> versionList = new ArrayList<>();
        for (Versions version: versions) {
            versionList.add(versionService.queryById(version.getVersion()));
        }
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询受教育所有版本", versionService.queryAll(id));
    }

    @ApiOperation("通过用户id查询用户所有受教育情况")
    @GetMapping("all/{id}")
    public ResponseResult queryAll(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询用户所有受教育情况", this.educationService.queryAll(id));
    }





}