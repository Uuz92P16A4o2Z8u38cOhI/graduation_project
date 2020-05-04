package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 科研活动(Research)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
@Data
public class Research implements Serializable {
    private static final long serialVersionUID = 778278011134132918L;
    /**
    * id
    */
    private Long id;
    /**
    * 研究领域
    */
    private Long researchAreas;
    /**
    * 论文成果
    */
    private Long thesisResults;
    /**
    * 专利
    */
    private Long patent;
    /**
    * 著作成果
    */
    private Long achievements;
    /**
    * 科研项目
    */
    private Long researchProjects;
    /**
    * 科研团队
    */
    private Long researchTeam;

    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    /**
    * 上传时间
    */
    private Date uploadTime;


    private Long version;

}