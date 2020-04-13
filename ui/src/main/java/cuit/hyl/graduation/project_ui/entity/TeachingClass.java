package cuit.hyl.graduation.project_ui.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 授课信息(TeachingClass)实体类
 *
 * @author makejava
 * @since 2020-04-09 17:43:52
 */
public class TeachingClass implements Serializable {
    private static final long serialVersionUID = -56385170110860765L;
    /**
    * id
    */
    private Long id;
    /**
    * 类型 1、本科生，2、研究生
    */
    private Integer type;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 学年
    */
    private String schoolYear;
    /**
    * 学期
    */
    private Integer semester;
    /**
    * 学时
    */
    private Integer hours;
    /**
    * 学分
    */
    private Double credit;
    /**
    * 课程号
    */
    private String courseNum;
    
    private Long classInfoId;

    private Long peopleId;

    private Timestamp uploadTime;

    private Integer version;

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public Long getClassInfoId() {
        return classInfoId;
    }

    public void setClassInfoId(Long classInfoId) {
        this.classInfoId = classInfoId;
    }

}