package cuit.hyl.graduation.project_ui.service.impl;

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
    public List<Research> initInfo(Long id) {
        return this.researchDao.initInfo(id);
    }

    @Override
    public List<ResearchItem> queryItems(Long id, Integer type) {
        return this.researchDao.queryItems(id, type);
    }
}