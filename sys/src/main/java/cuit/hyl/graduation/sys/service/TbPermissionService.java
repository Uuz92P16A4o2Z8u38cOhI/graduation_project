package cuit.hyl.graduation.sys.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbPermission;

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
}