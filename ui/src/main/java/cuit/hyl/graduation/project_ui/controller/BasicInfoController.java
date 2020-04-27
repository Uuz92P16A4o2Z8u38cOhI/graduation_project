package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import cuit.hyl.graduation.project_ui.service.feign.FastDFSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    /**
     * 通过用户id查询单条数据
     */
    @ApiOperation("通过用户id查询单条数据")
    @GetMapping("queryByPeopleId/{id}")
    public ResponseResult queryByPeopleId(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.basicInfoService.queryByPeopleId(id).get(0));
    }

    @ApiOperation("通过用户id查询初始化数据")
    @GetMapping("queryInitInfo/{id}")
    public ResponseResult queryInitInfo(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.basicInfoService.queryInitInfo(id).get(0));
    }

    @ApiOperation("通过用户id查询初始化数据")
    @PostMapping("querySchoolInfo/{id}")
    public ResponseResult querySchoolInfo(@PathVariable Long id) {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功查询数据", this.basicInfoService.schoolInfo(id));
    }

    @ApiOperation("上传头像")
    @PostMapping(value = "uploadAvatar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult uploadAvatar(@PathVariable Long id, MultipartFile dropFile) {
        ResponseResult result = new ResponseResult();

        String fileName  = fastDFSService.uploadAvatar(dropFile);

        this.basicInfoService.updateAvatar(fileName, this.basicInfoService.queryInitInfo(id).get(0).getId());

        result.setData(fileName);
        return result;
    }

}