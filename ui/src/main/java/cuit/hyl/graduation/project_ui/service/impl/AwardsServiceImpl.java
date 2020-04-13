package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.Awards;
import cuit.hyl.graduation.project_ui.dao.AwardsDao;
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
    public Awards queryById(Long id) {
        return this.awardsDao.queryById(id);
    }


}