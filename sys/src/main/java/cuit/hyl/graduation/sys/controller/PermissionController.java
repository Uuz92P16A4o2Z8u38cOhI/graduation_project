package cuit.hyl.graduation.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.TbPermission;
import cuit.hyl.graduation.sys.service.TbPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "权限查询")
@RequestMapping("api/sys/permission")
@RestController
public class PermissionController {
    @Autowired
    private TbPermissionService tbPermissionService;

    @ApiOperation(value="查询所有角色--分页")
    @GetMapping("allPermission/{pageNum}/{pageSize}")
    Map queryAllPermission(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<TbPermission> list = this.tbPermissionService.queryAllPermission();
        PageInfo<TbPermission> pageInfo = new PageInfo<TbPermission> (list);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo",pageInfo);
        return map;
    }

}
