package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.Version;
import cuit.hyl.graduation.project_ui.service.VersionService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Version)表控制层
 *
 * @author makejava
 * @since 2020-05-05 15:58:38
 */
@Slf4j
@Api(tags = "版本管理")
@RestController
@RequestMapping("api/ui/version")
public class VersionController {
    /**
     * 服务对象
     */
    @Resource
    private VersionService versionService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation("查询一条版本信息---主键id")
    @PostMapping("selectOne/{id}")
    public ResponseResult selectOne(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.versionService.queryById(id));
    }

    @ApiOperation("查询用户所有版本信息---用户id")
    @PostMapping("selectAll/{id}")
    public ResponseResult selectAll(@PathVariable Long id) {
        Version version = new Version();
        version.setPeopleId(id);
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.versionService.queryAll(id));
    }

    @ApiOperation("保存新版本信息")
    @PostMapping("save/{id}")
    @Transactional
    public ResponseResult save(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("peopleId", id);
        int i = this.versionService.insert(params);



        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }

    @ApiOperation("修改某版本信息")
    @PostMapping("update")
    public ResponseResult update(@RequestBody(required = false) JSONObject params) {
        int i = this.versionService.update(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }

    public void saveVersion(){

    }

}