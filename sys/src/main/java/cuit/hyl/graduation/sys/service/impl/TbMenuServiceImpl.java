package cuit.hyl.graduation.sys.service.impl;

import cuit.hyl.graduation.sys.dao.TbMenuDao;
import cuit.hyl.graduation.sys.entity.TbMenu;
import cuit.hyl.graduation.sys.service.TbMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-02-23 19:25:04
 */
@Service("tbMenuService")
public class TbMenuServiceImpl implements TbMenuService {
    @Resource
    private TbMenuDao tbMenuDao;

    @Override
    public List<TbMenu> queryById(Integer id) {
        return this.tbMenuDao.queryById(id);
    }

}