package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.ResponseResult;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.entity.TbUser;
import cuit.hyl.graduation.sys.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户查询")
@RequestMapping("api/sys/user")
@RestController
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ApiOperation(value="查询所有用户--分页")
    @PostMapping("allUser/{pageNum}/{pageSize}")
    ResponseResult queryAllUser(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                              @RequestBody(required = false) JSONObject params){
        PageHelper.startPage(pageNum,pageSize);
        List<TbUser> list = this.tbUserService.queryAllUser(params);
        PageInfo<TbUser> pageInfo = new PageInfo<TbUser> (list);
        return new ResponseResult(ResponseResult.CodeStatus.OK,pageInfo);
    }

    @ApiOperation(value="新增角色")
    @PostMapping("insertUser")
    ResponseResult insertUser(@RequestBody JSONObject params){
        if (params.get("password") != null){
            params.put("password", new BCryptPasswordEncoder().encode(params.get("password").toString())) ;
        }
        int row = this.tbUserService.insertUser(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功新增一个用户", "新增" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "新增失败" , "新增" + row + "行");
        }
    }

    @ApiOperation(value="更新角色")
    @PutMapping("updateUser")
    ResponseResult updateUser(@RequestBody JSONObject params){
        if (params.get("password") != null){
            params.put("password", new BCryptPasswordEncoder().encode(params.get("password").toString())) ;
        }
        int row = this.tbUserService.updateUser(params);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功修改一个用户", "修改" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "修改失败" , "修改" + row + "行");
        }
    }

    @ApiOperation(value="删除权限资源--根据id")
    @DeleteMapping("deleteUser/{id}")
    ResponseResult deleteUser(@PathVariable Long id){
        int row = this.tbUserService.deleteUser(id);
        if (row == 1){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除一个用户", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }

    @ApiOperation(value="删除用户--批量")
    @PostMapping("multipleDeleteUser")
    ResponseResult multipleDeleteUser(@RequestBody Long[] id){
        int row = this.tbUserService.multipleDeleteUser(id);
        if (row != 0){
            return new ResponseResult(ResponseResult.CodeStatus.OK,"成功删除"+row+"个用户", "删除" + row + "行");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL, "删除失败" , "删除" + row + "行");
        }
    }


}

