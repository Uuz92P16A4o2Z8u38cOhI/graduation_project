package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.dao.BasicInfoDao;
import cuit.hyl.graduation.project_ui.entity.vo.InitInfo;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import org.springframework.stereotype.Service;

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
    public List<BasicInfo> queryByPeopleId(Integer id) {
        return this.basicInfoDao.queryByPeopleId(id);
    }

    @Override
    public List<InitInfo> queryInitInfo(Integer id) {
        return this.basicInfoDao.queryInitInfo(id);
    }

    @Override
    public int excelImport(List<BasicInfo> list) {
        return this.basicInfoDao.excelImport(list);
    }


}