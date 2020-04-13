package cuit.hyl.graduation.project_ui.dao;

import cuit.hyl.graduation.project_ui.entity.Research;
import cuit.hyl.graduation.project_ui.entity.ResearchItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科研活动(Research)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
@Mapper
public interface ResearchDao {

    List<Research> initInfo(Long id);

    List<ResearchItem> queryItems(Long id, Integer type);
}