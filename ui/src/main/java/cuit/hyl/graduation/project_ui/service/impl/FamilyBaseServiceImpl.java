package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.dao.FamilyBaseDao;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;
import cuit.hyl.graduation.project_ui.service.FamilyBaseService;
import org.springframework.stereotype.Service;

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
    public List<FamilyBase> initInfo(Long id) {
        return this.familyBaseDao.initInfo(id);
    }

    @Override
    public List<FamilyMember> memberByBaseId(Long id) {
        return this.familyBaseDao.memberByBaseId(id);
    }
}