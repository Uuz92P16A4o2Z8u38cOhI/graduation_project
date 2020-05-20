package cuit.hyl.graduation.sys.controller;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.ResponseResult;
import cuit.hyl.graduation.sys.entity.TbMenu;
import cuit.hyl.graduation.sys.entity.vo.MenuTree;
import cuit.hyl.graduation.sys.entity.vo.PermissionTree;
import cuit.hyl.graduation.sys.entity.vo.UserVo;
import cuit.hyl.graduation.sys.service.TbMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (TbMenu)表控制层
 *
 * @author makejava
 * @since 2020-02-23 19:25:04
 */
@Slf4j
@Api(tags = "菜单查询")
@RestController
@RequestMapping("api/sys/menu")
public class TbMenuController {

    @Resource
    private TbMenuService tbMenuService;

    @ApiOperation(value="根据用户id查询目录菜单")
    @PostMapping("menuInfo")
    public List<TbMenu> menuInfo() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
        Long id = Long.parseLong(userVo.getId());
        List<TbMenu> sortMenu = new ArrayList<TbMenu>();
        List<TbMenu> menuList = this.tbMenuService.queryById(id);

        menuList.forEach(list ->{
            if(list.getParentId() == -1){
                sortMenu.add(list);
            }
        });
        addMenu(sortMenu, menuList);
        return sortMenu;
    }

    public void addMenu(List<TbMenu> menus, List<TbMenu> menuList){
        if (menus.size() != menuList.size()) {
            for (TbMenu menu : menus) {
                menu.setChildren(menuList.stream().filter(list -> list.getParentId().equals(menu.getId())).collect(Collectors.toList()));
                addMenu(menu.getChildren(),menuList);
            }
        }
    }
}