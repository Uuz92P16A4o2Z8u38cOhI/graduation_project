package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.sql.Date;
import java.io.Serializable;

/**
 * 工作情况(Work)实体类
 *
 * @author makejava
 * @since 2020-03-25 19:38:13
 */
public class Work implements Serializable {
    private static final long serialVersionUID = -48890067351278327L;

    private Long id;
    /**
    * 职位
    */
    @Excel(name = "职位", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String position;
    /**
    * 工作单位/学校
    */
    @Excel(name = "工作单位/学校", orderNum = "2", width = 30)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String workUnit;
    /**
    * 学院/部门
    */
    @Excel(name = "学院/部门", orderNum = "3", width = 20)
    @ExcelAttributes(exportSort = 2, importSort = 2)
    private String college;
    /**
    * 学科
    */
    @Excel(name = "学科", orderNum = "4", width = 20)
    @ExcelAttributes(exportSort = 3, importSort = 3)
    private String subject;
    /**
    * 开始时间
    */
    @Excel(name = "开始时间", format = "yyyy-MM-dd", orderNum = "5", width = 25)
    @ExcelAttributes(exportSort = 4, importSort = 4)
    private Date startTime;
    /**
    * 结束时间
    */
    @Excel(name = "结束时间", format = "yyyy-MM-dd", orderNum = "6", width = 25)
    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Date endTime;
    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    @Excel(name = "版本", orderNum = "7", width = 5)
    @ExcelAttributes(exportSort = 6, importSort = 6)
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

}