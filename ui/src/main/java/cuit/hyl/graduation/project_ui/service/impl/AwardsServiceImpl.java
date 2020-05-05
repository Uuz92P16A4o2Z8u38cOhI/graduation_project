package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.dao.AwardsDao;
import cuit.hyl.graduation.project_ui.entity.AwardsItem;
import cuit.hyl.graduation.project_ui.service.AwardsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获奖信息(Awards)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
@Service("awardsService")
public class AwardsServiceImpl implements AwardsService {
    @Resource
    private AwardsDao awardsDao;


    @Override
    public List<Awards> initInfo(Long id,Long version) {
        return this.awardsDao.initInfo(id, version);
    }

    @Override
    public List<AwardsItem> initItemInfo(Long id, Integer type) {
        return this.awardsDao.initItemInfo(id, type);
    }

    @Override
    public int insertAwards(Awards params) {
        return this.awardsDao.insertAwards(params);
    }

    @Override
    public int insertAwardsItem(JSONObject params) {
        return this.awardsDao.insertAwardsItem(params);
    }

    @Override
    public int updateAwardsItem(JSONObject params) {
        return this.awardsDao.updateAwardsItem(params);
    }

    @Override
    public int deleteAwardsItem(Long id) {
        return this.awardsDao.deleteAwardsItem(id);
    }
}