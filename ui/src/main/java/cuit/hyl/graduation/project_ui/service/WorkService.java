package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.Work;
import cuit.hyl.graduation.project_ui.entity.vo.Versions;

import java.util.List;

/**
 * 工作情况(Work)表服务接口
 *
 * @author makejava
 * @since 2020-03-25 19:38:13
 */
public interface WorkService {

    /**
     * 通过ID查询单条数据
     */
    List<Work> queryInitInfo(Long id);

    /**
     * 通过版本查询
     */
    List<Work> queryByVersion(Long id, Integer version);

    /**
     * 查询所有版本号
     */
    List<Versions> queryAllVersion(Long id);

    /**
     * excel 导出所有
     */
    List<Work> queryAll(Long id);

    int easyExcelImport(List<Work> list);
}