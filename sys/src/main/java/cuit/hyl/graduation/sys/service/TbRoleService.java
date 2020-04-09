package cuit.hyl.graduation.sys.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbRole;
import cuit.hyl.graduation.sys.entity.vo.RoleTree;

import java.util.List;

/**
 * 角色表(TbRole)表服务接口
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
public interface TbRoleService {

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

    /*int insertUserRole();

    int multipleInsertUserRole();*/
}