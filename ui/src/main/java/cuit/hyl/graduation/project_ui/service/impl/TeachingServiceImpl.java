package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.Teaching;
import cuit.hyl.graduation.project_ui.dao.TeachingDao;
import cuit.hyl.graduation.project_ui.entity.TeachingClass;
import cuit.hyl.graduation.project_ui.entity.TeachingItem;
import cuit.hyl.graduation.project_ui.service.TeachingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教学活动(Teaching)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
@Service("teachingService")
public class TeachingServiceImpl implements TeachingService {
    @Resource
    private TeachingDao teachingDao;


    @Override
    public List<Teaching> initTeach(Long id) {
        return this.teachingDao.initTeach(id);
    }

    @Override
    public List<TeachingClass> initTeachClass(Integer type, Long id) {
        return this.teachingDao.initTeachClass(type,id);
    }

    @Override
    public List<TeachingItem> initTeachItem(Integer type, Long id) {
        return this.teachingDao.initTeachItem(type, id);
    }
}