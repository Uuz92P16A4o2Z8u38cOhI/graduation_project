package cuit.hyl.graduation.security_oauth.dao;

import cuit.hyl.graduation.security_oauth.entity.TbRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色表(TbRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
@Mapper
public interface TbRoleDao {

    List<TbRole> queryAllRole();
}