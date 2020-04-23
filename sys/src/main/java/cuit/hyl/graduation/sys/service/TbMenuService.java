package cuit.hyl.graduation.sys.service;

import cuit.hyl.graduation.sys.entity.TbMenu;

import java.util.List;

/**
 * (TbMenu)表服务接口
 *
 * @author makejava
 * @since 2020-02-23 19:25:04
 */
public interface TbMenuService {

    List<TbMenu> queryById(Long id);

}