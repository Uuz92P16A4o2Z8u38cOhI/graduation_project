package cuit.hyl.graduation.project_ui.service;

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
    List<Education> queryInitInfo(Long id);

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
}