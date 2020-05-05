package cuit.hyl.graduation.project_ui.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Version;
import java.util.List;

/**
 * (Version)表服务接口
 *
 * @author makejava
 * @since 2020-05-05 15:58:38
 */
public interface VersionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Version queryById(Long id);

    List<Version> queryAll(Long id);

    /**
     * 新增数据
     * @return 实例对象
     */
    int insert(JSONObject params);

    /**
     * 修改数据
     * @return 实例对象
     */
    int update(JSONObject params);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}