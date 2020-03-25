package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.vo.InitInfo;

import java.util.List;

/**
 * 基础信息(BasicInfo)表服务接口
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
public interface BasicInfoService {

    /**
     * 通过用户ID查询单条数据
     */
    List<BasicInfo> queryByPeopleId(Integer id);

    /**
     * 通过用户ID查询初始化信息
     */
    List<InitInfo> queryInitInfo(Integer id);

    /**
     * excel导入
     */
    int excelImport(List<BasicInfo> list);

}