package cuit.hyl.graduation.sys.service;

import cuit.hyl.graduation.sys.entity.TbPermission;

import java.util.List;

/**
 * 权限表(TbPermission)表服务接口
 *
 * @author makejava
 * @since 2019-12-07 13:47:37
 */
public interface TbPermissionService {

    List<TbPermission> queryByUserId(Long id);

    List<TbPermission> queryAllPermission();
}