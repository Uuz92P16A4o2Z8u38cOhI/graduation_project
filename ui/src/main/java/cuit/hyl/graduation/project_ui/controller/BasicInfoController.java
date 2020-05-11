package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.School;
import cuit.hyl.graduation.project_ui.entity.vo.InitInfo;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import cuit.hyl.graduation.project_ui.service.feign.FastDFSService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 基础信息(BasicInfo)表控制层
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
@Slf4j
@Api(tags = "基础信息")
@RestController
@RequestMapping("api/ui/basicInfo")
public class BasicInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BasicInfoService basicInfoService;

    @Autowired
    private FastDFSService fastDFSService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,3);


    @ApiOperation("通过用户id查询单条数据")
    @GetMapping("queryByPeopleId/{id}/{version}")
    public ResponseResult queryByPeopleId(@PathVariable Long id, @PathVariable Long version) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        List<BasicInfo> basicInfoList = this.basicInfoService.queryByPeopleId(id, version);
        if (basicInfoList.size() == 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"未设置教师基础信息");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", basicInfoList.get(0));
        }
    }

    @ApiOperation("用户初始设置或修改基础信息")
    @PostMapping("insertOrUpdate/{id}")
    public ResponseResult insertOrUpdate(@PathVariable Long id,@RequestBody(required = false) JSONObject params) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        List<BasicInfo> basicInfoList = this.basicInfoService.queryByPeopleId(id, 0l);
        int i;
        if (basicInfoList.size() == 0){
            params.put("id", idWorker.nextId());
            params.put("peopleId", id);
            i = this.basicInfoService.insertInitInfo(params);
        }else {
            i = this.basicInfoService.updateInitInfo(params);
        }
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"操作失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"操作成功");
        }

    }

    @ApiOperation("通过用户id查询初始化数据")
    @GetMapping("queryInitInfo/{id}")
    public ResponseResult queryInitInfo(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        List<InitInfo> initInfos = this.basicInfoService.queryInitInfo(id, 0l);
        if (initInfos.size() == 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"暂无您的数据，请进行设置");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", initInfos.get(0));
        }
    }

    @ApiOperation("通过用户id查询初始化数据")
    @PostMapping("querySchoolInfo/{id}")
    public ResponseResult querySchoolInfo(@PathVariable Long id) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        School school = this.basicInfoService.schoolInfo(id);
        if (school == null){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"您暂无学校信息，请进行设置");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", school);
        }
    }

    @ApiOperation("上传头像")
    @PostMapping(value = "uploadAvatar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult uploadAvatar(@PathVariable Long id, MultipartFile dropFile) {
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        ResponseResult result = new ResponseResult();

        String fileName  = fastDFSService.uploadAvatar(dropFile);

        this.basicInfoService.updateAvatar(fileName, this.basicInfoService.queryInitInfo(id,0l).get(0).getId());

        result.setData(fileName);
        return result;
    }

}