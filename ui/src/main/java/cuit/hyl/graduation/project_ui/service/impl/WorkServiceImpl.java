package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Work;
import cuit.hyl.graduation.project_ui.dao.WorkDao;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import cuit.hyl.graduation.project_ui.service.WorkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作情况(Work)表服务实现类
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    @Override
    public List<Work> queryInitInfo(Long id,Long version) {
        return this.workDao.queryInitInfo(id, version);
    }

    @Override
    @Transactional
    public int insertItem(JSONObject params) {
        return this.workDao.insertItem(params);
    }

    @Override
    @Transactional
    public int updateItem(JSONObject params) {
        return this.workDao.updateItem(params);
    }

    @Override
    @Transactional
    public int deleteItem(Long id) {
        return workDao.deleteItem(id);
    }

    @Override
    public int insertForeach(List<Work> list) {
        return this.workDao.insertForeach(list);
    }

    @Override
    public List<Work> queryByVersion(Long id, Integer version) {
        return this.workDao.queryByVersion(id,version);
    }

    @Override
    public List<Versions> queryAllVersion(Long id) {
        return this.workDao.queryAllVersion(id);
    }

    @Override
    public List<Work> queryAll(Long id) {
        return this.workDao.queryAll(id);
    }

    @Override
    @Transactional
    public int easyExcelImport(List<Work> list) {
        return this.workDao.easyExcelImport(list);
    }
}