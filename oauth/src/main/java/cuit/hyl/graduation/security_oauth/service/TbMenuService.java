package cuit.hyl.graduation.security_oauth.service;

import cuit.hyl.graduation.security_oauth.entity.TbMenu;
import java.util.List;

/**
 * (TbMenu)表服务接口
 *
 * @author makejava
 * @since 2020-02-23 19:25:04
 */
public interface TbMenuService {

    List<TbMenu> queryById(Integer id);

}