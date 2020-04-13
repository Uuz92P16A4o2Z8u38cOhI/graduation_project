package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.Awards;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 获奖信息(Awards)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
@Mapper
public interface AwardsDao {

    Awards queryById(Long id);


}