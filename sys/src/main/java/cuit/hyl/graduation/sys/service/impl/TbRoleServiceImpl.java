package cuit.hyl.graduation.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.dao.TbRoleDao;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.service.TbRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<TbRole> queryAllRole(JSONObject params) {
        return tbRoleDao.queryAllRole(params);
    }

    @Override
    @Transactional
    public int insertRole(JSONObject params) {
        return this.tbRoleDao.insertRole(params);
    }

    @Override
    @Transactional
    public int updateRole(JSONObject parans) {
        return this.tbRoleDao.updateRole(parans);
    }

    @Override
    @Transactional
    public int deleteRole(Long id) {
        return this.tbRoleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public int multipleDeleteRole(Long[] id) {
        return this.tbRoleDao.multipleDeleteRole(id);
    }
}