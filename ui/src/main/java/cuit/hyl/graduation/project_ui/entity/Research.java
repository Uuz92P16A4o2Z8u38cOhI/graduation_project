package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.util.Date;
import java.io.Serializable;

/**
 * 科研活动(Research)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:21:01
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(Long researchAreas) {
        this.researchAreas = researchAreas;
    }

    public Long getThesisResults() {
        return thesisResults;
    }

    public void setThesisResults(Long thesisResults) {
        this.thesisResults = thesisResults;
    }

    public Long getPatent() {
        return patent;
    }

    public void setPatent(Long patent) {
        this.patent = patent;
    }

    public Long getAchievements() {
        return achievements;
    }

    public void setAchievements(Long achievements) {
        this.achievements = achievements;
    }

    public Long getResearchProjects() {
        return researchProjects;
    }

    public void setResearchProjects(Long researchProjects) {
        this.researchProjects = researchProjects;
    }

    public Long getResearchTeam() {
        return researchTeam;
    }

    public void setResearchTeam(Long researchTeam) {
        this.researchTeam = researchTeam;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

}