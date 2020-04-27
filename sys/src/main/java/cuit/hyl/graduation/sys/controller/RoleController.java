package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.*;
import cuit.hyl.graduation.sys.entity.vo.RoleTree;
import cuit.hyl.graduation.sys.service.TbRoleService;
import cuit.hyl.graduation.sys.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Api(tags = "角色查询")
@RequestMapping("api/sys/role")
@RestController
public class RoleController {
    @Autowired
    private TbRoleService tbRoleService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

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
        params.put("id", idWorker.nextId());
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

    /*@ApiOperation(value="查询所有角色--分页")
    @PostMapping("allRoleTree")
    ResponseResult queryAllRoleTree(){
        List<TbRole> list = this.tbRoleService.queryAllRole();
        PageInfo<TbRole> pageInfo = new PageInfo<TbRole> (list);
        return new ResponseResult(ResponseResult.CodeStatus.OK,pageInfo);
    }*/

    @ApiOperation(value="查询用户拥有的角色")
    @PostMapping("queryByUserId/{id}")
    ResponseResult queryByUserId(@PathVariable Long id){
        Long[] ids = this.tbRoleService.queryByUserIds(id);
        List<RoleTree> adminList = this.tbRoleService.roleTree(0L);
        List<RoleTree> webList = this.tbRoleService.roleTree(1L);
        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);

        List<RoleTree> sortAdminList = new ArrayList<>();
        List<RoleTree> sortWebList = new ArrayList<>();

        adminList.forEach(list ->{
            if(list.getParentId() == 0){
                sortAdminList.add(list);
            }
        });
        webList.forEach(list ->{
            if(list.getParentId() == 1){
                sortWebList.add(list);
            }
        });
        addMenu(sortAdminList, adminList);
        addMenu(sortWebList, webList);

        map.put("sortAdminList",sortAdminList);
        map.put("sortWebList",sortWebList);

        return new ResponseResult(ResponseResult.CodeStatus.OK,map);
    }

    public void addMenu(List<RoleTree> menus, List<RoleTree> menuList){
        if (menus.size() != menuList.size()) {
            for (RoleTree menu : menus) {
                menu.setChildren(menuList.stream().filter(list -> list.getParentId().equals(menu.getId())).collect(Collectors.toList()));
                addMenu(menu.getChildren(),menuList);
            }
        }
    }

    @Transactional
    @ApiOperation(value="更新用户拥有的角色")
    @PostMapping("multipleInsertUserRole/{id}")
    ResponseResult multipleInsertUserRole(@PathVariable Long id,@RequestBody Long[] ids){
        List<TbUserRole> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++){
            TbUserRole tbUserRole = new TbUserRole();
            tbUserRole.setId(idWorker.nextId());
            tbUserRole.setRoleId(ids[i]);
            tbUserRole.setUserId(id);
            list.add(tbUserRole);
        }
        this.tbRoleService.multipleDeleteAllUserRole(id);
        this.tbRoleService.multipleInsertUserRole(list);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "更新成功");
    }
}
