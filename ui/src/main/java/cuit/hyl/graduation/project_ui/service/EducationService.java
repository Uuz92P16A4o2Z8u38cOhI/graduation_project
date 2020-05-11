package cuit.hyl.graduation.project_ui.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;

import java.util.List;

/**
 * 教育经历(Education)表服务接口
 *
 * @author makejava
 * @since 2020-04-02 20:22:55
 */
public interface EducationService {

    /**
     * 通过ID查询单条数据
     */
    List<Education> queryInitInfo(Long id,Long version);

    int insertItem(JSONObject params);
    int updateItem(JSONObject params);
    int deleteItem(Long id);

    int insertForeach(List<Education> list);

    /**
     * 通过版本查询
     */
    List<Education> queryByVersion(Long id, String version);

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