package cuit.hyl.graduation.project_ui.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.entity.AwardsItem;

import java.util.List;

/**
 * 获奖信息(Awards)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
public interface AwardsService {


    List<Awards> initInfo(Long id);

    List<AwardsItem> initItemInfo(Long id, Integer type);


    int insertAwards(Awards params);
    int insertAwardsItem(JSONObject params);
    int updateAwardsItem(JSONObject params);
    int deleteAwardsItem(Long id);
}