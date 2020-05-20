package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Version;
import cuit.hyl.graduation.project_ui.entity.Work;
import cuit.hyl.graduation.project_ui.entity.vo.UserVo;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import cuit.hyl.graduation.project_ui.service.VersionService;
import cuit.hyl.graduation.project_ui.service.WorkService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 工作情况(Work)表控制层
 */
@Slf4j
@Api(tags = "工作信息")
@RestController
@RequestMapping("api/ui/work")
public class WorkController {
    /**
     * 服务对象
     */
    @Resource
    private WorkService workService;
    @Resource
    private VersionService versionService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation("通过用户id查询工作页面初始化消息")
    @GetMapping("initInfo/{version}")
    public ResponseResult queryInitInfo(@PathVariable Long version) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        List<Work> works = this.workService.queryInitInfo(id,version);
        if (works.size() == 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"未设置教师工作情况");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", works);
        }
//        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询initInfo数据", this.workService.queryInitInfo(id));
    }

    @ApiOperation("用户新增工作情况")
    @PostMapping("insertItem")
    public ResponseResult insertItem(@RequestBody(required = false) JSONObject params) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        params.put("id", idWorker.nextId());
        params.put("peopleId", id);
        int i = this.workService.insertItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("用户更新工作情况")
    @PostMapping("updateItem")
    public ResponseResult updateItem(@RequestBody(required = false) JSONObject params) {
        int i = this.workService.updateItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("用户删除工作情况")
    @DeleteMapping("deleteItem/{id}")
    public ResponseResult deleteItem(@PathVariable Long id) {
        int i = this.workService.deleteItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }




    @ApiOperation("通过用户id 版本号查询工作消息")
    @GetMapping("version/{version}")
    public ResponseResult queryByVersion(@PathVariable String version) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询", this.workService.queryByVersion(id,version));
    }

    @ApiOperation("通过用户id查询工作所有版本")
    @GetMapping("allVersion")
    public ResponseResult queryAllVersion() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询工作所有版本", versionService.queryAll(id));
    }

    @ApiOperation("通过用户id查询用户所有工作")
    @GetMapping("all")
    public ResponseResult queryAll() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询用户所有工作", this.workService.queryAll(id));
    }

}