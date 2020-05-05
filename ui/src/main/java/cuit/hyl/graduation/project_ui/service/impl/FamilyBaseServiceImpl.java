package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.dao.FamilyBaseDao;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;
import cuit.hyl.graduation.project_ui.service.FamilyBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 家庭情况_基础(FamilyBase)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 16:29:15
 */
@Service("familyBaseService")
public class FamilyBaseServiceImpl implements FamilyBaseService {
    @Resource
    private FamilyBaseDao familyBaseDao;

    @Override
    public List<FamilyBase> initInfo(Long id,Long version) {
        return this.familyBaseDao.initInfo(id,version);
    }

    @Override
    public List<FamilyMember> memberByBaseId(Long id) {
        return this.familyBaseDao.memberByBaseId(id);
    }

    @Override
    @Transactional
    public int insertbase(JSONObject params) {
        return this.familyBaseDao.insertbase(params);
    }

    @Override
    @Transactional
    public int updatebase(JSONObject params) {
        return this.familyBaseDao.updatebase(params);
    }

    @Override
    @Transactional
    public int insertItem(JSONObject params) {
        return this.familyBaseDao.insertItem(params);
    }

    @Override
    @Transactional
    public int updateItem(JSONObject params) {
        return this.familyBaseDao.updateItem(params);
    }

    @Override
    @Transactional
    public int deleteItem(Long id) {
        return this.familyBaseDao.deleteItem(id);
    }

    @Override
    @Transactional
    public int easyExcelImportBase(List<FamilyBase> list) {
        return this.familyBaseDao.easyExcelImportBase(list);
    }

    @Override
    @Transactional
    public int easyExcelImportMember(List<FamilyMember> list) {
        return this.familyBaseDao.easyExcelImportMember(list);
    }
}