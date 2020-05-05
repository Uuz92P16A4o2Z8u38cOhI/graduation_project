package cuit.hyl.graduation.project_ui.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Version;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Version)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-05 15:58:38
 */
@Mapper
public interface VersionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Version queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    List<Version> queryAll(Long id);

    /**
     * 新增数据
     * @return 影响行数
     */
    int insert(JSONObject params);

    /**
     * 修改数据
     * @return 影响行数
     */
    int update(JSONObject params);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}