package cuit.hyl.graduation.security_oauth.dao;

import cuit.hyl.graduation.security_oauth.entity.TbMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 19:25:02
 */
@Mapper
public interface TbMenuDao {

    List<TbMenu> queryById(Integer id);

}