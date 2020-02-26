package cuit.hyl.graduation.sys.controller;

import com.github.pagehelper.PageHelper;
import cuit.hyl.graduation.sys.entity.TbUser;
import cuit.hyl.graduation.sys.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户查询")
@RequestMapping("api/sys/user")
@RestController
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ApiOperation(value="查询所有用户--分页")
    @GetMapping("allUser/{pageNum}/{pageSize}")
    List<TbUser> queryAllRole(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return this.tbUserService.queryAllUser();
    }
}
