package cuit.hyl.graduation.security_oauth.dao;

import cuit.hyl.graduation.security_oauth.entity.TbPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限表(TbPermission)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-07 13:47:37
 */
@Mapper
public interface TbPermissionDao {

    List<TbPermission> queryByUserId(Long id);

}