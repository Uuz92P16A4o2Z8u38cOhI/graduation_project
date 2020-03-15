package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.ResponseResult;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.service.TbRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色查询")
@RequestMapping("api/sys/role")
@RestController
public class RoleController {
    @Autowired
    private TbRoleService tbRoleService;

    @ApiOperation(value="查询所有角色--分页")
    @PostMapping("allRole/{pageNum}/{pageSize}")
    ResponseResult queryAllRole(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                @RequestBody(required = false) JSONObject params){
        PageHelper.startPage(pageNum,pageSize);
        List<TbRole> list = this.tbRoleService.queryAllRole(params);
        PageInfo<TbRole> pageInfo = new PageInfo<TbRole> (list);
        return new ResponseResult(ResponseResult.CodeStatus.OK,pageInfo);
    }

    @ApiOperation(value="新增角色")
    @PostMapping("insertRole")
    ResponseResult insertRole(@RequestBody JSONObject params){
        int row = this.tbRoleService.insertRole(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功新增一个角色", "新增" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "新增失败" , "新增" + row + "行");
        }
    }

    @ApiOperation(value="更新角色")
    @PutMapping("updateRole")
    ResponseResult updateRole(@RequestBody JSONObject params){
        int row = this.tbRoleService.updateRole(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功修改一个角色", "修改" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "修改失败" , "修改" + row + "行");
        }
    }

    @ApiOperation(value="删除权限资源--根据id")
    @DeleteMapping("deleteRole/{id}")
    ResponseResult deleteRole(@PathVariable Long id){
        int row = this.tbRoleService.deleteRole(id);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除一个角色", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }

    @ApiOperation(value="删除权限资源--批量")
    @PostMapping("multipleDeleteRole")
    ResponseResult multipleDeleteRole(@RequestBody Long[] id){
        int row = this.tbRoleService.multipleDeleteRole(id);
        if (row != 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除"+row+"个角色", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }
}
