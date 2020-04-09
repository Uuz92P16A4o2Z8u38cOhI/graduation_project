package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.dao.EducationDao;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import cuit.hyl.graduation.project_ui.service.EducationService;
import org.springframework.stereotype.Service;

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
    public List<Education> queryInitInfo(Long id) {
        return this.educationDao.queryInitInfo(id);
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
}