package cuit.hyl.graduation.project_ui.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.entity.AwardsItem;
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

    List<Awards> initInfo(Long id,Long version);

    List<AwardsItem> initItemInfo(Long id, Integer type);

    int insertAwards(Awards params);
    int insertAwardsItem(JSONObject params);
    int updateAwardsItem(JSONObject params);
    int deleteAwardsItem(Long id);

}