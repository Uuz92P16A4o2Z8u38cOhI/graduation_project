package cuit.hyl.graduation.sys.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbPermission;
import cuit.hyl.graduation.sys.entity.TbRoleMenu;
import cuit.hyl.graduation.sys.entity.TbRolePermission;
import cuit.hyl.graduation.sys.entity.vo.MenuTree;
import cuit.hyl.graduation.sys.entity.vo.PermissionTree;

import java.util.Arrays;
import java.util.List;

/**
 * 权限表(TbPermission)表服务接口
 *
 * @author makejava
 * @since 2019-12-07 13:47:37
 */
public interface TbPermissionService {

    List<TbPermission> queryByUserId(Long id);

    List<TbPermission> queryAllPermission(JSONObject params);

    int insertPermission(JSONObject params);

    int updatePermission(JSONObject parans);

    int deletePermission(Long id);

    int multipleDeletePermission(Long[] id);

//    -----------------------------

    List<TbPermission> queryPermissionByRoleId(Long id);

    int insertRolePermission(Long roleId, Long permissionId);

    int deleteRolePermission(Long[] id);

    Long[] permissionIds(Long id);
    Long[] menuIds(Long id);
    List<PermissionTree> permissionTree();
    List<MenuTree> menuTree();

    int multipleDeleteAllRoleMenu(Long id);
    int multipleDeleteAllRolePermission(Long id);
    int multipleInsertRoleMenu(List<TbRoleMenu> list);
    int multipleInsertRolePermission(List<TbRolePermission> list);
}