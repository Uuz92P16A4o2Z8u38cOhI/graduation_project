package cuit.hyl.graduation.project_ui.dao;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
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

    List<FamilyBase> initInfo(Long id,Long version);

    List<FamilyMember> memberByBaseId(Long id);

    int insertbase(JSONObject params);
    int updatebase(JSONObject params);
    int insertItem(JSONObject params);
    int updateItem(JSONObject params);
    int deleteItem(Long id);

    int easyExcelImportBase(List<FamilyBase> list);

    int easyExcelImportMember(List<FamilyMember> list);

}