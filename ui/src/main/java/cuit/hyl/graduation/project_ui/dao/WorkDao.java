package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 工作情况(Work)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 19:38:13
 */
@Mapper
public interface WorkDao {

    /**
     * 通过ID查询单条数据
     */
    List<Work> queryInitInfo(Integer id);

    /**
     * 通过版本查询
     */
    List<Work> queryByVersion(Integer id, Integer version);

    /**
     * 查询所有版本号
     */
    int[] queryAllVersion(Integer id);

    /**
     * excel 导出所有
     */
    List<Work> queryAll(Integer id);




}