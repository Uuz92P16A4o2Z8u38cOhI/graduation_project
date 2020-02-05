package cuit.hyl.graduation.security_oauth.controller;

import cuit.hyl.graduation.security_oauth.entity.TbRole;
import cuit.hyl.graduation.security_oauth.service.TbRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "角色查询")
@RequestMapping("api/oauth/role")
@RestController
public class RoleController {
    @Autowired
    private TbRoleService tbRoleService;

    @ApiOperation(value="查询所有角色")
    @GetMapping("allRole")
    List<TbRole> queryAllRole(){
        return this.tbRoleService.queryAllRole();
    }
}
