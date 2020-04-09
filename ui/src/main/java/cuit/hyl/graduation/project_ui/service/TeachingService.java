package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.Teaching;
import cuit.hyl.graduation.project_ui.entity.TeachingClass;
import cuit.hyl.graduation.project_ui.entity.TeachingItem;

import java.util.List;

/**
 * 教学活动(Teaching)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
public interface TeachingService {

    List<Teaching> initTeach(Long id);

    List<TeachingClass> initTeachClass(Integer type, Long id);

    List<TeachingItem> initTeachItem(Integer type, Long id);

}