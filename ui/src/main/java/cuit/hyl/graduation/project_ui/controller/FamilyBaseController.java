package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.FamilyBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 家庭情况_基础(FamilyBase)表控制层
 *
 * @author makejava
 * @since 2020-04-09 16:29:15
 */
@Api(tags = "家庭情况")
@RestController
@RequestMapping("api/ui/family")
public class FamilyBaseController {
    /**
     * 服务对象
     */
    @Resource
    private FamilyBaseService familyBaseService;


    @ApiOperation("通过用户id查询家庭情况页面初始化消息")
    @PostMapping("initInfo/{id}")
    public ResponseResult initInfo(@PathVariable Long id) {
        ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<>();

        FamilyBase familyBase = familyBaseService.initInfo(id).get(0);
        List<FamilyMember> members = null;
        if (familyBase != null){
            members = familyBaseService.memberByBaseId(familyBase.getId());
            if (members == null){
                result.setMessage("未添加家庭成员！");
            }
        }else {
            result.setMessage("未设置家庭信息！");
        }
        map.put("familyBase",familyBase);
        map.put("members",members);
        result.setData(map);

        return result;
    }

}