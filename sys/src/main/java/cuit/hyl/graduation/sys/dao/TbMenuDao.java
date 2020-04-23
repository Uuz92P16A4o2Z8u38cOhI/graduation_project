package cuit.hyl.graduation.sys.dao;

import cuit.hyl.graduation.sys.entity.TbMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (TbMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 19:25:02
 */
@Mapper
public interface TbMenuDao {

    List<TbMenu> queryById(Long id);

}