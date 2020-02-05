package cuit.hyl.graduation.security_oauth.service.impl;

import cuit.hyl.graduation.security_oauth.entity.TbRole;
import cuit.hyl.graduation.security_oauth.dao.TbRoleDao;
import cuit.hyl.graduation.security_oauth.service.TbRoleService;
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