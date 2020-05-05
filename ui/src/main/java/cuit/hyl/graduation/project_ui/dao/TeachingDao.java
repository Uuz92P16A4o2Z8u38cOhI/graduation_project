package cuit.hyl.graduation.project_ui.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Teaching;
import cuit.hyl.graduation.project_ui.entity.TeachingClass;
import cuit.hyl.graduation.project_ui.entity.TeachingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 教学活动(Teaching)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
@Mapper
public interface TeachingDao {

    List<Teaching> initTeach(Long id,Long version);

    List<TeachingClass> initTeachClass(Integer type,Long id);

    List<TeachingItem> initTeachItem(Integer type,Long id);


    int insertTeach(Teaching params);
    int insertTeachItem(JSONObject params);
    int updateTeachItem(JSONObject params);
    int deleteTeachItem(Long id);
    int insertTeachClass(JSONObject params);
    int updateTeachClass(JSONObject params);
    int deleteTeachClass(Long id);

}