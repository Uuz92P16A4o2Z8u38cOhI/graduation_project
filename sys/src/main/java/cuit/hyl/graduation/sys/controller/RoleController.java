package cuit.hyl.graduation.sys.controller;

import com.github.pagehelper.PageHelper;
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
    List<TbRole> queryAllRole(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return this.tbRoleService.queryAllRole();
    }
}
