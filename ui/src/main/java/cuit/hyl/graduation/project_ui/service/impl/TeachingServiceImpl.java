package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
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
    public List<Teaching> initTeach(Long id,Long version) {
        return this.teachingDao.initTeach(id,version);
    }

    @Override
    public List<TeachingClass> initTeachClass(Integer type, Long id) {
        return this.teachingDao.initTeachClass(type,id);
    }

    @Override
    public List<TeachingItem> initTeachItem(Integer type, Long id) {
        return this.teachingDao.initTeachItem(type, id);
    }

    @Override
    public int insertTeach(Teaching params) {
        return this.teachingDao.insertTeach(params);
    }

    @Override
    public int insertTeachItem(JSONObject params) {
        return this.teachingDao.insertTeachItem(params);
    }

    @Override
    public int updateTeachItem(JSONObject params) {
        return this.teachingDao.updateTeachItem(params);
    }

    @Override
    public int deleteTeachItem(Long id) {
        return this.teachingDao.deleteTeachItem(id);
    }

    @Override
    public int insertTeachClass(JSONObject params) {
        return this.teachingDao.insertTeachClass(params);
    }

    @Override
    public int updateTeachClass(JSONObject params) {
        return this.teachingDao.updateTeachClass(params);
    }

    @Override
    public int deleteTeachClass(Long id) {
        return this.teachingDao.deleteTeachClass(id);
    }
}