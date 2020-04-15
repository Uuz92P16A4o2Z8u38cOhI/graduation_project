package cuit.hyl.graduation.project_ui.service;

import cuit.hyl.graduation.project_ui.entity.Research;
import cuit.hyl.graduation.project_ui.entity.ResearchItem;

import java.util.List;

/**
 * 科研活动(Research)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
public interface ResearchService {

    List<Research> initInfo(Long id);

    List<ResearchItem> queryItems(Long id, Integer type);



}