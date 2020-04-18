package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.FamilyBase;
import cuit.hyl.graduation.project_ui.entity.FamilyMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 家庭情况_基础(FamilyBase)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 16:29:15
 */
@Mapper
public interface FamilyBaseDao {

    List<FamilyBase> initInfo(Long id);

    List<FamilyMember> memberByBaseId(Long id);

    int easyExcelImportBase(List<FamilyBase> list);

    int easyExcelImportMember(List<FamilyMember> list);

}