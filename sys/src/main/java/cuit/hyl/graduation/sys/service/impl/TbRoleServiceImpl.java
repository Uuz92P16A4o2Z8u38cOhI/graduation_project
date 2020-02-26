package cuit.hyl.graduation.sys.service.impl;

import cuit.hyl.graduation.sys.dao.TbRoleDao;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色表(TbRole)表服务实现类
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleDao tbRoleDao;

    @Override
    public List<TbRole> queryAllRole() {
        return tbRoleDao.queryAllRole();
    }
}