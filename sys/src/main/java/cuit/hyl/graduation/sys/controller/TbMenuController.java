package cuit.hyl.graduation.sys.controller;

import cuit.hyl.graduation.sys.entity.TbMenu;
import cuit.hyl.graduation.sys.service.TbMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (TbMenu)表控制层
 *
 * @author makejava
 * @since 2020-02-23 19:25:04
 */
@Api(tags = "菜单查询")
@RestController
@RequestMapping("api/sys/menu")
public class TbMenuController {

    @Resource
    private TbMenuService tbMenuService;

    @ApiOperation(value="根据用户id查询目录菜单")
    @GetMapping("menuInfo/{id}")
    public List<TbMenu> menuInfo(@PathVariable("id") Integer id) {
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