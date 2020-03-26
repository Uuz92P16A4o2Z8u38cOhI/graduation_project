package cuit.hyl.graduation.project_ui.entity;

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
    
    private Integer id;
    /**
    * 职位
    */
    private String position;
    /**
    * 工作单位/学校
    */
    private String workUnit;
    /**
    * 学院/部门
    */
    private String college;
    /**
    * 学科
    */
    private String subject;
    /**
    * 开始时间
    */
    private Date startTime;
    /**
    * 结束时间
    */
    private Date endTime;
    
    private Integer peopleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

}