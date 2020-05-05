package cuit.hyl.graduation.project_ui.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.Research;
import cuit.hyl.graduation.project_ui.dao.ResearchDao;
import cuit.hyl.graduation.project_ui.entity.ResearchItem;
import cuit.hyl.graduation.project_ui.service.ResearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科研活动(Research)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
@Service("researchService")
public class ResearchServiceImpl implements ResearchService {
    @Resource
    private ResearchDao researchDao;


    @Override
    public List<Research> initInfo(Long id,Long version) {
        return this.researchDao.initInfo(id, version);
    }

    @Override
    public List<ResearchItem> queryItems(Long id, Integer type) {
        return this.researchDao.queryItems(id, type);
    }

    @Override
    public int insertResearch(Research params) {
        return this.researchDao.insertResearch(params);
    }

    @Override
    public int insertResearchItem(JSONObject params) {
        return this.researchDao.insertResearchItem(params);
    }

    @Override
    public int updateResearchItem(JSONObject params) {
        return this.researchDao.updateResearchItem(params);
    }

    @Override
    public int deleteResearchItem(Long id) {
        return this.researchDao.deleteResearchItem(id);
    }
}