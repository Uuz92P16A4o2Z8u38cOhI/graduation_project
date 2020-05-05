package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Version;
import cuit.hyl.graduation.project_ui.dao.VersionDao;
import cuit.hyl.graduation.project_ui.service.VersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Version)表服务实现类
 *
 * @author makejava
 * @since 2020-05-05 15:58:38
 */
@Service("versionService")
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionDao versionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Version queryById(Long id) {
        return this.versionDao.queryById(id);
    }

    @Override
    public List<Version> queryAll(Long id) {
        return this.versionDao.queryAll(id);
    }



    /**
     * 新增数据
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(JSONObject params) {
        return this.versionDao.insert(params);
    }

    /**
     * 修改数据
     */
    @Override
    @Transactional
    public int update(JSONObject params) {

        return this.versionDao.update(params);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return this.versionDao.deleteById(id) > 0;
    }
}