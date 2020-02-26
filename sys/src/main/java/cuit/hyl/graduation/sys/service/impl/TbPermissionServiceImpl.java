package cuit.hyl.graduation.sys.service.impl;

import cuit.hyl.graduation.sys.dao.TbPermissionDao;
import cuit.hyl.graduation.sys.entity.TbPermission;
import cuit.hyl.graduation.sys.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<TbPermission> queryAllPermission() {
        return this.tbPermissionDao.queryAllPermission();
    }


}