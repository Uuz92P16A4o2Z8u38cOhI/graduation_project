package cuit.hyl.graduation.security_oauth.service.impl;

import cuit.hyl.graduation.security_oauth.entity.TbPermission;
import cuit.hyl.graduation.security_oauth.dao.TbPermissionDao;
import cuit.hyl.graduation.security_oauth.service.TbPermissionService;
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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<TbPermission> queryByUserId(Long id) {
        return this.tbPermissionDao.queryByUserId(id);
    }

    @Override
    public List<TbPermission> queryAllPermission() {
        return this.tbPermissionDao.queryAllPermission();
    }


}