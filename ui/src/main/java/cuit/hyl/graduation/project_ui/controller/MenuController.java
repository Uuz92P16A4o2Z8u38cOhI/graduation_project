package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.Menu;
import cuit.hyl.graduation.project_ui.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.effect.Light;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2019-12-26 15:27:58
 */
@Api(tags = "前端目录")
@RestController
@RequestMapping("api/ui/menuTree")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    @ApiOperation(value = "嵌套菜单")
    @GetMapping("/menuInfo")
    public List<Menu> menuInfo(){
        Long parentId = -1L;
        List<Menu> menu = this.menuService.queryByParentId(parentId);
        addMenu(menu);
        return menu;
    }

    @ApiOperation(value = "并列所有菜单")
    @GetMapping("/menuAll")
    public List<Menu> menuAll(){
        return this.menuService.queryAll();
    }

    public void addMenu(List<Menu> menus){
        if (menus.size() != 0) {
            for (Menu menu : menus) {
                if (!(this.menuService.queryByParentId(menu.getId()).isEmpty())) {
                    menu.setChildren(this.menuService.queryByParentId(menu.getId()));
                    addMenu(menu.getChildren());
                }
            }
        }
    }
}