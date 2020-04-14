package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.io.Serializable;

/**
 * 教学活动(Teaching)实体类
 *
 * @author makejava
 * @since 2020-04-09 17:43:05
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResearch() {
        return research;
    }

    public void setResearch(Long research) {
        this.research = research;
    }

    public Long getResources() {
        return resources;
    }

    public void setResources(Long resources) {
        this.resources = resources;
    }

    public Long getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Long classInfo) {
        this.classInfo = classInfo;
    }

    public Long getAchievements() {
        return achievements;
    }

    public void setAchievements(Long achievements) {
        this.achievements = achievements;
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