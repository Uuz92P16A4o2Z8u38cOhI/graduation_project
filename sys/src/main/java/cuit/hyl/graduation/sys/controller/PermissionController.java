package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.ResponseResult;
import cuit.hyl.graduation.sys.entity.TbPermission;
import cuit.hyl.graduation.sys.service.TbPermissionService;
import cuit.hyl.graduation.sys.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "权限查询")
@RequestMapping("api/sys/permission")
@RestController
public class PermissionController {
    @Autowired
    private TbPermissionService tbPermissionService;

    @ApiOperation(value="查询所有资源--分页")
    @PostMapping("allPermission/{pageNum}/{pageSize}")
    ResponseResult queryAllPermission(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                      @RequestBody(required = false) JSONObject params){
        PageHelper.startPage(pageNum, pageSize);
        List<TbPermission> list = this.tbPermissionService.queryAllPermission(params);
        PageInfo<TbPermission> pageInfo = new PageInfo<TbPermission> (list);
        return new ResponseResult(ResponseResult.CodeStatus.OK,pageInfo);
    }

    @ApiOperation(value="新增权限资源")
    @PostMapping("insertPermission")
    ResponseResult insertPermission(@RequestBody JSONObject params){
        int row = this.tbPermissionService.insertPermission(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功新增一条资源权限", "新增" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "新增失败" , "新增" + row + "行");
        }
    }

    @ApiOperation(value="更新权限资源")
    @PutMapping("updatePermission")
    ResponseResult updatePermission(@RequestBody JSONObject params){
        int row = this.tbPermissionService.updatePermission(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功修改一条资源权限", "修改" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "修改失败" , "修改" + row + "行");
        }
    }

    @ApiOperation(value="删除权限资源--根据id")
    @DeleteMapping("deletePermission/{id}")
    ResponseResult deletePermission(@PathVariable Long id){
        int row = this.tbPermissionService.deletePermission(id);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除一条资源权限", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }

    @ApiOperation(value="删除权限资源--批量")
    @PostMapping("multipleDeletePermission")
    ResponseResult multipleDeletePermission(@RequestBody Long[] id){
        int row = this.tbPermissionService.multipleDeletePermission(id);
        if (row != 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除"+row+"条资源权限", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }

    //    ----------------------------------------

    @ApiOperation(value="通过角色Id查看资源")
    @PostMapping("queryPermissionByRoleId")
    ResponseResult queryPermissionByRoleId(@RequestBody Long id){
        List<TbPermission> list = this.tbPermissionService.queryPermissionByRoleId(id);

        return new ResponseResult(ResponseResult.CodeStatus.OK, list);
    }

    @ApiOperation(value="新增角色-权限资源")
    @PostMapping("insertRolePermission")
    ResponseResult insertRolePermission(@RequestBody JSONObject params){
        Long roleId = (Long) params.get("roleId");
        Long permissionId = (Long) params.get("permissionId");
        int row = this.tbPermissionService.insertRolePermission(roleId, permissionId);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功新增一条资源权限", "新增" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "新增失败" , "新增" + row + "行");
        }
    }

    @ApiOperation(value="删除角色-权限资源--批量")
    @PostMapping("deleteRolePermission")
    ResponseResult deleteRolePermission(@RequestBody Long[] id){
        int row = this.tbPermissionService.deleteRolePermission(id);
        if (row != 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除"+row+"条资源权限", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }
}
