package cuit.hyl.graduation.project_ui.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 获奖信息(Awards)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
public class Awards implements Serializable {
    private static final long serialVersionUID = -65572673573107950L;
    /**
    * id
    */
    private Long id;
    /**
    * 学术荣誉
    */
    private Long academicHonors;
    /**
    * 科研奖项
    */
    private Long scientificAwards;
    /**
    * 其它获奖
    */
    private Long otherAwards;
    /**
    * 荣誉称号
    */
    private Long honoraryTitle;
    
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

    public Long getAcademicHonors() {
        return academicHonors;
    }

    public void setAcademicHonors(Long academicHonors) {
        this.academicHonors = academicHonors;
    }

    public Long getScientificAwards() {
        return scientificAwards;
    }

    public void setScientificAwards(Long scientificAwards) {
        this.scientificAwards = scientificAwards;
    }

    public Long getOtherAwards() {
        return otherAwards;
    }

    public void setOtherAwards(Long otherAwards) {
        this.otherAwards = otherAwards;
    }

    public Long getHonoraryTitle() {
        return honoraryTitle;
    }

    public void setHonoraryTitle(Long honoraryTitle) {
        this.honoraryTitle = honoraryTitle;
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