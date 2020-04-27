package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.entity.AwardsItem;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.AwardsService;
import cuit.hyl.graduation.project_ui.service.feign.FastDFSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation("通过用户id查询获奖情况页面初始化消息")
    @PostMapping("initInfo/{id}")
    public ResponseResult initInfo(@PathVariable Long id) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        Awards awards = this.awardsService.initInfo(id).get(0);
        if (awards != null){
            List<AwardsItem> academicHonorsList = this.awardsService.initItemInfo(awards.getAcademicHonors(), 1);
            List<AwardsItem> scientificAwardsList = this.awardsService.initItemInfo(awards.getScientificAwards(), 2);
            List<AwardsItem> otherAwardsList = this.awardsService.initItemInfo(awards.getOtherAwards(), 3);
            List<AwardsItem> honoraryTitleList = this.awardsService.initItemInfo(awards.getHonoraryTitle(), 4);
            List<AwardsItem> honorWallList = this.awardsService.initItemInfo(awards.getHonorWall(), 5);

            map.put("academicHonorsList", academicHonorsList);
            map.put("scientificAwardsList", scientificAwardsList);
            map.put("otherAwardsList", otherAwardsList);
            map.put("honoraryTitleList", honoraryTitleList);
            map.put("honorWallList", honorWallList);
        }

        result.setData(map);

        return result;
    }
}