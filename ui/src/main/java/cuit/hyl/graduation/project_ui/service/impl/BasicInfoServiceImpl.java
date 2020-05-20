package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.dao.BasicInfoDao;
import cuit.hyl.graduation.project_ui.entity.School;
import cuit.hyl.graduation.project_ui.entity.vo.InitInfo;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息(BasicInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
@Service("basicInfoService")
public class BasicInfoServiceImpl implements BasicInfoService {
    @Resource
    private BasicInfoDao basicInfoDao;

    /**
     * 通过用户ID查询单条数据
     */
    @Override
    public List<BasicInfo> queryByPeopleId(Long id, Long version) {
        return this.basicInfoDao.queryByPeopleId(id,version);
    }

    @Override
    public int insertInitInfo(JSONObject params) {
        return this.basicInfoDao.insertInitInfo(params);
    }

    @Override
    public int updateInitInfo(JSONObject params) {
        return this.basicInfoDao.updateInitInfo(params);
    }

    @Override
    public List<InitInfo> queryInitInfo(Long id,Long version) {
        return this.basicInfoDao.queryInitInfo(id, version);
    }

    @Override
    @Transactional
    public int excelImport(List<BasicInfo> list) {
        return this.basicInfoDao.excelImport(list);
    }

    @Override
    @Transactional
    public int easyPoiExcelImport(List<BasicInfo> list) {
        return this.basicInfoDao.easyPoiExcelImport(list);
    }

    @Override
    public School schoolInfo(Long id) {
        return this.basicInfoDao.schoolInfo(id);
    }

    @Override
    public int updateAvatar(String avatar, Long id) {
        return this.basicInfoDao.updateAvatar(avatar, id);
    }

    @Override
    public BasicInfo queryUserBaseInfo(Long id) {
        return this.basicInfoDao.queryUserBaseInfo(id);
    }


}