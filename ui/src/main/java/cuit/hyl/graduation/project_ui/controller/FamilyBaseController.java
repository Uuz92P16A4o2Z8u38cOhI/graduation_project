package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.vo.UserVo;
import cuit.hyl.graduation.project_ui.service.FamilyBaseService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

/**
 * 家庭情况_基础(FamilyBase)表控制层
 *
 * @author makejava
 * @since 2020-04-09 16:29:15
 */
@Slf4j
@Api(tags = "家庭情况")
@RestController
@RequestMapping("api/ui/family")
public class FamilyBaseController {
    /**
     * 服务对象
     */
    @Resource
    private FamilyBaseService familyBaseService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation("通过用户id查询家庭情况页面初始化消息")
    @PostMapping("initInfo/{version}")
    public ResponseResult initInfo(@PathVariable Long version) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        List<FamilyBase> familyBases = familyBaseService.initInfo(id, version);
        if (familyBases.size() == 0){
            result.setMessage("未设置家庭信息！");

            JSONObject params = new JSONObject();
            params.put("id", idWorker.nextId());
            params.put("peopleId", id);
            this.familyBaseService.insertbase(params);
        }else {
            FamilyBase familyBase = familyBases.get(0);
            List<FamilyMember> members = null;
            members = familyBaseService.memberByBaseId(familyBase.getId());
            if (members == null){
                result.setMessage("未添加家庭成员！");
            }
            map.put("familyBase",familyBase);
            map.put("members",members);
            result.setData(map);
        }

        return result;
    }


    @ApiOperation("新增、更新家庭基础信息")
    @PostMapping("insertOrUpdateBase")
    public ResponseResult insertOrUpdateBase(@RequestBody(required = false) JSONObject params) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult result = new ResponseResult();
        List<FamilyBase> familyBases = familyBaseService.initInfo(id, 0l);
        if (familyBases.size() == 0) {
            params.put("id", idWorker.nextId());
            params.put("peopleId", id);
            this.familyBaseService.insertbase(params);
            result.setMessage("新增家庭基础信息！");
        } else {
            this.familyBaseService.updatebase(params);
            result.setMessage("更新家庭基础信息！");
        }
        return result;
    }

    @ApiOperation("新增家庭成员")
    @PostMapping("insertItem/{id}")
    public ResponseResult insertItem(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("baseId", id);
        int i = this.familyBaseService.insertItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }
    @ApiOperation("更新家庭成员")
    @PostMapping("updateItem")
    public ResponseResult updateItem(@RequestBody(required = false) JSONObject params) {
        int i = this.familyBaseService.updateItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }
    @ApiOperation("删除家庭成员")
    @DeleteMapping("deleteItem/{id}")
    public ResponseResult deleteItem(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        int i = this.familyBaseService.deleteItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }





}