package cuit.hyl.graduation.project_ui.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.entity.AwardsItem;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.entity.vo.UserVo;
import cuit.hyl.graduation.project_ui.service.AwardsService;
import cuit.hyl.graduation.project_ui.service.feign.FastDFSService;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获奖信息(Awards)表控制层
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
@Slf4j
@Api(tags = "获奖情况")
@RestController
@RequestMapping("api/ui/awards")
public class AwardsController {
    /**
     * 服务对象
     */
    @Resource
    private AwardsService awardsService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation("通过用户id查询获奖情况页面初始化消息")
    @PostMapping("initInfo/{version}")
    public ResponseResult initInfo(@PathVariable Long version) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        List<Awards> awardsList = this.awardsService.initInfo(id, version);
        if (awardsList.size() != 0){
            Awards awards = awardsList.get(0);
            List<AwardsItem> academicHonorsList = this.awardsService.initItemInfo(awards.getAcademicHonors(), 1);
            List<AwardsItem> scientificAwardsList = this.awardsService.initItemInfo(awards.getScientificAwards(), 2);
            List<AwardsItem> otherAwardsList = this.awardsService.initItemInfo(awards.getOtherAwards(), 3);
            List<AwardsItem> honoraryTitleList = this.awardsService.initItemInfo(awards.getHonoraryTitle(), 4);
            List<AwardsItem> honorWallList = this.awardsService.initItemInfo(awards.getHonorWall(), 5);

            map.put("awards", awards);
            map.put("academicHonorsList", academicHonorsList);
            map.put("scientificAwardsList", scientificAwardsList);
            map.put("otherAwardsList", otherAwardsList);
            map.put("honoraryTitleList", honoraryTitleList);
            map.put("honorWallList", honorWallList);
        }else {
            Awards awards = new Awards();
            awards.setId(this.idWorker.nextId());
            awards.setAcademicHonors(this.idWorker.nextId());
            awards.setHonoraryTitle(this.idWorker.nextId());
            awards.setHonorWall(this.idWorker.nextId());
            awards.setOtherAwards(this.idWorker.nextId());
            awards.setPeopleId(id);
            awards.setScientificAwards(this.idWorker.nextId());
            this.awardsService.insertAwards(awards);
            result.setMessage("未设置教师获奖情况");
        }

        result.setData(map);

        return result;
    }


    @ApiOperation("新增获奖信息")
    @PostMapping("insertAwardsItem/{id}")
    public ResponseResult insertAwardsItem(@PathVariable Long id, @RequestBody(required = false) JSONObject params) {
        params.put("id", idWorker.nextId());
        params.put("parentId", id);
        int i = this.awardsService.insertAwardsItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"新增失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"新增成功");
        }
    }

    @ApiOperation("更新获奖信息")
    @PostMapping("updateAwardsItem")
    public ResponseResult updateAwardsItem(@RequestBody(required = false) JSONObject params) {
        int i = this.awardsService.updateAwardsItem(params);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"编辑失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"编辑成功");
        }
    }

    @ApiOperation("删除获奖信息")
    @DeleteMapping("deleteAwardsItem/{id}")
    public ResponseResult deleteAwardsItem(@PathVariable Long id) {
        int i = this.awardsService.deleteAwardsItem(id);
        if (i == 0){
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"删除失败");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK,"删除成功");
        }
    }
}