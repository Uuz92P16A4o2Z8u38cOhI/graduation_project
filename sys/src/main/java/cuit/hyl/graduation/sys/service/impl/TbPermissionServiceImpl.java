package cuit.hyl.graduation.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.dao.TbPermissionDao;
import cuit.hyl.graduation.sys.entity.TbPermission;
import cuit.hyl.graduation.sys.entity.TbRoleMenu;
import cuit.hyl.graduation.sys.entity.TbRolePermission;
import cuit.hyl.graduation.sys.entity.vo.MenuTree;
import cuit.hyl.graduation.sys.entity.vo.PermissionTree;
import cuit.hyl.graduation.sys.service.TbPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 权限表(TbPermission)表服务实现类
 *
 * @author makejava
 * @since 2019-12-07 13:47:37
 */
@Service("tbPermissionService")
public class TbPermissionServiceImpl implements TbPermissionService {
    @Resource
    private TbPermissionDao tbPermissionDao;


    @Override
    public List<TbPermission> queryByUserId(Long id) {
        return this.tbPermissionDao.queryByUserId(id);
    }

    @Override
    public List<TbPermission> queryAllPermission(JSONObject params) {
        return this.tbPermissionDao.queryAllPermission(params);
    }

    @Override
    @Transactional
    public int insertPermission(JSONObject params) {
        return this.tbPermissionDao.insertPermission(params);
    }

    @Override
    @Transactional
    public int updatePermission(JSONObject parans) {
        return this.tbPermissionDao.updatePermission(parans);
    }

    @Override
    @Transactional
    public int deletePermission(Long id) {
        return this.tbPermissionDao.deletePermission(id);
    }

    @Override
    public int multipleDeletePermission(Long[] id) {
        return this.tbPermissionDao.multipleDeletePermission(id);
    }

    @Override
    public List<TbPermission> queryPermissionByRoleId(Long id) {
        return this.tbPermissionDao.queryPermissionByRoleId(id);
    }

    @Override
    public int insertRolePermission(Long roleId, Long permissionId) {
        return this.tbPermissionDao.insertRolePermission(roleId, permissionId);
    }

    @Override
    public int deleteRolePermission(Long[] id) {
        return this.tbPermissionDao.deleteRolePermission(id);
    }

    @Override
    public Long[] permissionIds(Long id) {
        return this.tbPermissionDao.permissionIds(id);
    }

    @Override
    public Long[] menuIds(Long id) {
        return this.tbPermissionDao.menuIds(id);
    }

    @Override
    public List<PermissionTree> permissionTree() {
        return this.tbPermissionDao.permissionTree();
    }

    @Override
    public List<MenuTree> menuTree() {
        return this.tbPermissionDao.menuTree();
    }

    @Override
    public int multipleDeleteAllRoleMenu(Long id) {
        return this.tbPermissionDao.multipleDeleteAllRoleMenu(id);
    }

    @Override
    public int multipleDeleteAllRolePermission(Long id) {
        return this.tbPermissionDao.multipleDeleteAllRolePermission(id);
    }

    @Override
    public int multipleInsertRoleMenu(List<TbRoleMenu> list) {
        return this.tbPermissionDao.multipleInsertRoleMenu(list);
    }

    @Override
    public int multipleInsertRolePermission(List<TbRolePermission> list) {
        return this.tbPermissionDao.multipleInsertRolePermission(list);
    }


}