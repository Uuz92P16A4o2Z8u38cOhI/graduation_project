package cuit.hyl.graduation.security_oauth.service;

import cuit.hyl.graduation.security_oauth.entity.TbRole;
import java.util.List;

/**
 * 角色表(TbRole)表服务接口
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
public interface TbRoleService {

    List<TbRole> queryAllRole();
}