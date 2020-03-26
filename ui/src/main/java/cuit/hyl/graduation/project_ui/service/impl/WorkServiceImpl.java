package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.Work;
import cuit.hyl.graduation.project_ui.dao.WorkDao;
import cuit.hyl.graduation.project_ui.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作情况(Work)表服务实现类
 *
 * @author makejava
 * @since 2020-03-25 19:38:13
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    @Override
    public List<Work> queryInitInfo(Integer id) {
        return this.workDao.queryInitInfo(id);
    }

    @Override
    public List<Work> queryByVersion(Integer id, Integer version) {
        return this.workDao.queryByVersion(id,version);
    }

    @Override
    public int[] queryAllVersion(Integer id) {
        return this.workDao.queryAllVersion(id);
    }

    @Override
    public List<Work> queryAll(Integer id) {
        return this.workDao.queryAll(id);
    }
}