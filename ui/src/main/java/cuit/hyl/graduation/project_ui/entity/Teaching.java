package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 教学活动(Teaching)实体类
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
@Data
public class Teaching implements Serializable {
    private static final long serialVersionUID = -27930395255827298L;
    /**
    * id
    */
    private Long id;
    /**
    * 教学研究
    */
    private Long research;
    /**
    * 教学资源
    */
    private Long resources;
    /**
    * 授课信息
    */
    private Long classInfo;
    /**
    * 教学成果
    */
    private Long achievements;

    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    /**
    * 上传时间
    */
    private Date uploadTime;

    private Long version;

    private List<TeachingItem> researchList;

    private List<TeachingItem> resourcesList;

    private List<TeachingItem> achievementsList;

}