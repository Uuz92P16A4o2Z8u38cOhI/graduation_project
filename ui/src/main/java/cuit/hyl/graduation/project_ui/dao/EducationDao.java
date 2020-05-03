package cuit.hyl.graduation.project_ui.dao;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 教育经历(Education)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-02 20:22:55
 */
@Mapper
public interface EducationDao {

    /**
     * 通过ID查询单条数据
     */
    List<Education> queryInitInfo(Long id);

    int insertItem(JSONObject params);
    int updateItem(JSONObject params);
    int deleteItem(Long id);

    /**
     * 通过版本查询
     */
    List<Education> queryByVersion(Long id, Integer version);

    /**
     * 查询所有版本号
     */
    List<Versions> queryAllVersion(Long id);

    /**
     * excel 导出所有
     */
    List<Education> queryAll(Long id);

    int easyExcelImport(List<Education> list);

}