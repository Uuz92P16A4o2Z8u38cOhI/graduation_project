package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-26 15:27:55
 */
@Mapper
public interface MenuDao {

    /**
     * 通过PARENT_ID查询单条数据
     */
    List<Menu> queryByParentId(Long id);

    /**
     * 全部
     */
    List<Menu> queryAll();


}