package cuit.hyl.graduation.project_ui.service.impl;

import cuit.hyl.graduation.project_ui.entity.TeachUnit;
import cuit.hyl.graduation.project_ui.dao.TeachUnitDao;
import cuit.hyl.graduation.project_ui.service.TeachUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TeachUnit)表服务实现类
 *
 * @author makejava
 * @since 2020-02-04 19:48:03
 */
@Service("teachUnitService")
public class TeachUnitServiceImpl implements TeachUnitService {
    @Resource
    private TeachUnitDao teachUnitDao;

    @Override
    public List<TeachUnit> queryAll(Integer schoolCode) {
        return this.teachUnitDao.queryAll(schoolCode);
    }

}