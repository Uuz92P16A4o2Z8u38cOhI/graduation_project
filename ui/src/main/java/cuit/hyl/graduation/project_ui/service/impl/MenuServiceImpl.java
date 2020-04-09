package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.Menu;
import cuit.hyl.graduation.project_ui.dao.MenuDao;
import cuit.hyl.graduation.project_ui.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2019-12-26 15:27:58
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 通过parentId查询单条数据
     */
    @Override
    public List<Menu> queryByParentId(Long id) {
        return this.menuDao.queryByParentId(id);
    }

    @Override
    public List<Menu> queryAll() {
        return this.menuDao.queryAll();
    }


}