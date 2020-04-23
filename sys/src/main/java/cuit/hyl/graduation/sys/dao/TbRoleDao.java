package cuit.hyl.graduation.sys.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.entity.TbUserRole;
import cuit.hyl.graduation.sys.entity.vo.RoleTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表(TbRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
@Mapper
public interface TbRoleDao {

    List<TbRole> queryAllRole(JSONObject params);

    int insertRole(JSONObject params);

    int updateRole(JSONObject parans);

    int deleteRole(Long id);

    int multipleDeleteRole(Long[] id);

    List<RoleTree> queryByUserId(Long id);
    Long[] queryByUserIds(Long id);
    List<RoleTree> roleTree(Long id);

    int deleteUserRole(Long id);

    int multipleDeleteUserRole(Long[] id);

    int multipleDeleteAllUserRole(Long id);

    /*int insertUserRole();*/

    int multipleInsertUserRole(List<TbUserRole> list);
}