package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.util.Date;
import java.io.Serializable;

/**
 * 教育经历(Education)实体类
 *
 * @author makejava
 * @since 2020-04-02 20:22:54
 */
public class Education implements Serializable {
    private static final long serialVersionUID = 890685807107640271L;
    /**
    * id
    */
    private Long id;
    /**
    * 学校
    */
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String schoole;
    /**
    * 学历
    */
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String degree;
    /**
    * 专业
    */
    @ExcelAttributes(exportSort = 2, importSort = 2)
    private String subject;
    /**
    * 开始时间
    */
    @ExcelAttributes(exportSort = 3, importSort = 3)
    private Date startTime;
    /**
    * 结束时间
    */
    @ExcelAttributes(exportSort = 4, importSort = 4)
    private Date endTime;

    @ExcelAttributes(importSort = 999)
    private Integer peopleId;
    /**
    * 上传时间
    */
//    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Date uploadTime;
    /**
    * 版本号
    */
    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoole() {
        return schoole;
    }

    public void setSchoole(String schoole) {
        this.schoole = schoole;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}