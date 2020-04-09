package cuit.hyl.graduation.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.dao.TbRoleDao;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.entity.vo.RoleTree;
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

    @Override
    public List<RoleTree> queryByUserId(Long id) {
        return this.tbRoleDao.queryByUserId(id);
    }

    @Override
    public Long[] queryByUserIds(Long id){
        return this.tbRoleDao.queryByUserIds(id);
    }

    @Override
    public List<RoleTree> roleTree(Long id) {
        return this.tbRoleDao.roleTree(id);
    }


    @Override
    @Transactional
    public int deleteUserRole(Long id) {
        return this.tbRoleDao.deleteUserRole(id);
    }

    @Override
    @Transactional
    public int multipleDeleteUserRole(Long[] id) {
        return this.tbRoleDao.multipleDeleteUserRole(id);
    }

    /*@Override
    @Transactional
    public int insertUserRole() {
        return this.tbRoleDao.insertUserRole();
    }

    @Override
    @Transactional
    public int multipleInsertUserRole() {
        return this.tbRoleDao.multipleDeleteUserRole();
    }*/
}