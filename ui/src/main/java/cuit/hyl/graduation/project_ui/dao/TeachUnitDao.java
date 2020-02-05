package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.TeachUnit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TeachUnit)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-04 19:48:03
 */
@Mapper
public interface TeachUnitDao {

    List<TeachUnit> queryAll(Integer schoolCode);


}