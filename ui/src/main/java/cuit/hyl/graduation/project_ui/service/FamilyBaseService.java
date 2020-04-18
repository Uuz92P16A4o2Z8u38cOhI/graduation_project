package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;

import java.util.List;

/**
 * 家庭情况_基础(FamilyBase)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 16:29:15
 */
public interface FamilyBaseService {

    List<FamilyBase> initInfo(Long id);

    List<FamilyMember> memberByBaseId(Long id);

    int easyExcelImportBase(List<FamilyBase> list);

    int easyExcelImportMember(List<FamilyMember> list);
}