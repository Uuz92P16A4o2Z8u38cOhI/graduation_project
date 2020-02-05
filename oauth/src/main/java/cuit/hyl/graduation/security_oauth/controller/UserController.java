package cuit.hyl.graduation.security_oauth.controller;

import cuit.hyl.graduation.security_oauth.entity.TbUser;
import cuit.hyl.graduation.security_oauth.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户查询")
@RequestMapping("api/oauth/user")
@RestController
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ApiOperation(value="查询所有用户")
    @GetMapping("allUser")
    List<TbUser> queryAllRole(){
        return this.tbUserService.queryAllUser();
    }
}
