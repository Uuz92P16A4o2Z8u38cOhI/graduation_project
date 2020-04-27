package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.*;
import cuit.hyl.graduation.sys.entity.vo.MenuTree;
import cuit.hyl.graduation.sys.entity.vo.PermissionTree;
import cuit.hyl.graduation.sys.entity.vo.RoleTree;
import cuit.hyl.graduation.sys.service.TbPermissionService;
import cuit.hyl.graduation.sys.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Api(tags = "权限查询")
@RequestMapping("api/sys/permission")
@RestController
public class PermissionController {
    @Autowired
    private TbPermissionService tbPermissionService;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

    @ApiOperation(value="查询所有资源--分页")
    @PostMapping("allPermission/{pageNum}/{pageSize}")
    ResponseResult queryAllPermission(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                      @RequestBody(required = false) JSONObject params){
        PageHelper.startPage(pageNum, pageSize);
        List<TbPermission> list = this.tbPermissionService.queryAllPermission(params);
        PageInfo<TbPermission> pageInfo = new PageInfo<TbPermission> (list);
        log.info("查询所有资源--分页");
        return new ResponseResult(ResponseResult.CodeStatus.OK,pageInfo);
    }

    @ApiOperation(value="新增权限资源")
    @PostMapping("insertPermission")
    ResponseResult insertPermission(@RequestBody JSONObject params){
        params.put("id", idWorker.nextId());
        int row = this.tbPermissionService.insertPermission(params);
        if (row == 1){
            log.info("新增权限资源:" + "新增" + row + "行");
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
            log.info("成功修改一条资源权限:" + "修改" + row + "行");
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
            log.info("成功删除一条资源权限:" + "删除" + row + "行");
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
            log.info("成功删除"+row+"条资源权限");
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

    @ApiOperation(value="查询角色拥有的资源、菜单")
    @PostMapping("tree/{id}")
    ResponseResult tree(@PathVariable Long id){
        Map<String,Object> map = new HashMap<>();
        Long[] pIds = this.tbPermissionService.permissionIds(id);
        Long[] mIds = this.tbPermissionService.menuIds(id);
        List<PermissionTree> permissionTrees = this.tbPermissionService.permissionTree();
        List<MenuTree> menuTrees = this.tbPermissionService.menuTree();
        map.put("pIds", pIds);
        map.put("mIds", mIds);

        List<PermissionTree> sortPermissionList = new ArrayList<>();
        List<MenuTree> sortMenuList = new ArrayList<>();

        permissionTrees.forEach(list ->{
            if(list.getParentId() == 0){
                sortPermissionList.add(list);
            }
        });
        menuTrees.forEach(list ->{
            if(list.getParentId() == -1){
                sortMenuList.add(list);
            }
        });
        if (sortMenuList != null){
            addMenus(sortMenuList, menuTrees);
        }
        if (sortPermissionList != null){
            addPermission(sortPermissionList, permissionTrees);
        }
        map.put("sortMenuList", sortMenuList);
        map.put("sortPermissionList", sortPermissionList);
        return new ResponseResult(ResponseResult.CodeStatus.OK,map);
    }

    public void addPermission(List<PermissionTree> menus, List<PermissionTree> menuList){
        if (menus.size() != menuList.size()) {
            for (PermissionTree menu : menus) {
                menu.setChildren(menuList.stream().filter(list -> list.getParentId().equals(menu.getId())).collect(Collectors.toList()));
                addPermission(menu.getChildren(),menuList);
            }
        }
    }

    public void addMenus(List<MenuTree> menus, List<MenuTree> menuList){
        if (menus.size() != menuList.size()) {
            for (MenuTree menu : menus) {
                menu.setChildren(menuList.stream().filter(list -> list.getParentId().equals(menu.getId())).collect(Collectors.toList()));
                addMenus(menu.getChildren(),menuList);
            }
        }
    }

    @Transactional
    @ApiOperation(value="更新角色拥有的资源 ")
    @PostMapping("multipleInsertRolePermission/{id}")
    ResponseResult multipleInsertRolePermission(@PathVariable Long id,@RequestBody Long[] ids){
        List<TbRolePermission> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++){
            TbRolePermission tbRolePermission = new TbRolePermission();
            tbRolePermission.setId(idWorker.nextId());
            tbRolePermission.setPermissionId(ids[i]);
            tbRolePermission.setRoleId(id);
            list.add(tbRolePermission);
        }
        this.tbPermissionService.multipleDeleteAllRolePermission(id);
        this.tbPermissionService.multipleInsertRolePermission(list);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "更新成功");
    }

    @Transactional
    @ApiOperation(value="更新角色拥有的菜单 ")
    @PostMapping("multipleInsertRoleMenu/{id}")
    ResponseResult multipleInsertRoleMenu(@PathVariable Long id,@RequestBody Long[] ids){
        List<TbRoleMenu> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++){
            TbRoleMenu tbRoleMenu = new TbRoleMenu();
            tbRoleMenu.setId(idWorker.nextId());
            tbRoleMenu.setMenuId(ids[i]);
            tbRoleMenu.setRoleId(id);
            list.add(tbRoleMenu);
        }
        this.tbPermissionService.multipleDeleteAllRoleMenu(id);
        this.tbPermissionService.multipleInsertRoleMenu(list);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "更新成功");
    }
}
