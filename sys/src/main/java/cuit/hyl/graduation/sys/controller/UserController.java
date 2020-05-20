package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cuit.hyl.graduation.sys.entity.ResponseResult;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.entity.TbUser;
import cuit.hyl.graduation.sys.entity.vo.UserVo;
import cuit.hyl.graduation.sys.service.TbUserService;
import cuit.hyl.graduation.sys.utils.RedisUtils;
import cuit.hyl.graduation.sys.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "用户查询")
@RequestMapping("api/sys/user")
@RestController
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private RedisUtils redisUtils;

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,4);

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
        params.put("id", idWorker.nextId());
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

    @ApiOperation(value="删除用户--根据id")
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

    @ApiOperation(value="邮件发送验证码更新密码")
    @PostMapping("updatePasswordByEmail")
    ResponseResult updatePasswordByEmail(@RequestBody JSONObject params){
        String newpassword = (String) params.get("newpassword");
        String password = (String) params.get("password");
        String email = (String) params.get("email");

        Long id = this.tbUserService.checkEmail(email);
        if (id == null) {
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"不存在该邮箱用户，请重新输入邮箱号");
        }else {
            String check = (String) redisUtils.get(email);
            if (password.equals(check)){
                int row = this.tbUserService.updatePasswordByEmail(email,new BCryptPasswordEncoder().encode(newpassword));
                if (row == 0){
                    return new ResponseResult(ResponseResult.CodeStatus.FAIL,"密码更新失败");
                }else {
                    return new ResponseResult(ResponseResult.CodeStatus.OK,"修改密码成功");
                }
            }else {
                return new ResponseResult(ResponseResult.CodeStatus.FAIL,"验证码过期或错误");
            }
        }
    }

    @ApiOperation(value="用户修改密码")
    @PutMapping("updatePassword")
    ResponseResult updatePassword(@RequestBody JSONObject params){
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        ResponseResult responseResult = new ResponseResult();

        TbUser tbUser = tbUserService.queryById(id);
        String password = (String) params.get("password");
        String newPassword = (String) params.get("newPassword");

        boolean i = new BCryptPasswordEncoder().matches(password,tbUser.getPassword());
        if (i){
            int j = this.tbUserService.updatePassword(id, new BCryptPasswordEncoder().encode(newPassword));
            responseResult.setMessage("密码修改成功！！  请重新登录！");
            responseResult.setCode(ResponseResult.CodeStatus.OK);
        }else {
            responseResult.setMessage("密码错误！！");
            responseResult.setCode(ResponseResult.CodeStatus.FAIL);
        }
        return responseResult;
    }


}

