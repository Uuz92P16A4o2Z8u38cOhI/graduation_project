package cuit.hyl.graduation.security_oauth.service.impl;

import cuit.hyl.graduation.security_oauth.entity.TbMenu;
import cuit.hyl.graduation.security_oauth.dao.TbMenuDao;
import cuit.hyl.graduation.security_oauth.service.TbMenuService;
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