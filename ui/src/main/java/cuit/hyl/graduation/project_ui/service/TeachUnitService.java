package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.TeachUnit;
import java.util.List;

/**
 * (TeachUnit)表服务接口
 *
 * @author makejava
 * @since 2020-02-04 19:48:03
 */
public interface TeachUnitService {


    List<TeachUnit> queryAll(Integer schoolCode);

}