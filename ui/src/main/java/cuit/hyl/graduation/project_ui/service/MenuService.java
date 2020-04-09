package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.Menu;
import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2019-12-26 15:27:57
 */
public interface MenuService {

    /**
     * 通过parentId查询单条数据
     */
    List<Menu> queryByParentId(Long id);

    /**
     * 全部查询
     */
    List<Menu> queryAll();
}