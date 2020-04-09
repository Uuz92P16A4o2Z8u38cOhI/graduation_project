package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.vo.InitInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 基础信息(BasicInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
@Mapper
public interface BasicInfoDao {

    /**
     * 通过用户ID查询单条数据
     */
    List<BasicInfo> queryByPeopleId(Long id);

    /**
     * 通过用户ID查询初始化信息
     */
    List<InitInfo> queryInitInfo(Long id);

    /**
     * excel导入
     */
    int excelImport(List<BasicInfo> list);


}