package cuit.hyl.graduation.security_oauth.service;

import cuit.hyl.graduation.security_oauth.entity.TbUser;
import java.util.List;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2019-12-07 13:32:07
 */
public interface TbUserService {

    List<TbUser> queryByUserName(String username);

    List<TbUser> queryAllUser();
}