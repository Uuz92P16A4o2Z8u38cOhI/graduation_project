package cuit.hyl.graduation.security_oauth.controller;

import cuit.hyl.graduation.security_oauth.entity.TbPermission;
import cuit.hyl.graduation.security_oauth.service.TbPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "权限查询")
@RequestMapping("api/oauth/permission")
@RestController
public class PermissionController {
    @Autowired
    private TbPermissionService tbPermissionService;

    @ApiOperation(value="查询所有角色")
    @GetMapping("allPermission")
    List<TbPermission> queryAllPermission(){
        return this.tbPermissionService.queryAllPermission();
    }

}
