package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.dao.EducationDao;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import cuit.hyl.graduation.project_ui.service.EducationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教育经历(Education)表服务实现类
 *
 * @author makejava
 * @since 2020-04-02 20:22:55
 */
@Service("educationService")
public class EducationServiceImpl implements EducationService {
    @Resource
    private EducationDao educationDao;

    @Override
    public List<Education> queryInitInfo(Long id,Long version) {
        return this.educationDao.queryInitInfo(id, version);
    }

    @Override
    @Transactional
    public int insertItem(JSONObject params) {
        return this.educationDao.insertItem(params);
    }

    @Override
    @Transactional
    public int updateItem(JSONObject params) {
        return this.educationDao.updateItem(params);
    }

    @Override
    @Transactional
    public int deleteItem(Long id) {
        return this.educationDao.deleteItem(id);
    }

    @Override
    public int insertForeach(List<Education> list) {
        return this.educationDao.insertForeach(list);
    }

    @Override
    public List<Education> queryByVersion(Long id, Integer version) {
        return this.educationDao.queryByVersion(id, version);
    }

    @Override
    public List<Versions> queryAllVersion(Long id) {
        return this.educationDao.queryAllVersion(id);
    }

    @Override
    public List<Education> queryAll(Long id) {
        return this.educationDao.queryAll(id);
    }

    @Override
    @Transactional
    public int easyExcelImport(List<Education> list) {
        return this.educationDao.easyExcelImport(list);
    }
}