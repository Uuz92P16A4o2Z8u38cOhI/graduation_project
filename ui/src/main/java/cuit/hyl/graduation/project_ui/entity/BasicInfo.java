package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 基础信息(BasicInfo)实体类
 *
 * @author makejava
 * @since 2020-03-17 18:16:27
 */
public class BasicInfo implements Serializable {
    private static final long serialVersionUID = 266121383832773046L;


    @ExcelAttributes(importSort = 1000)
    private Long id;
    /**
    * 姓名
    */
    @Excel(name = "姓名", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String name;
    /**
    * 昵称
    */
    @Excel(name = "昵称", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String nickName;
    /**
    * 性别
    */
    @Excel(name = "性别", replace = {"男_1","女_0"}, orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 2, importSort = 2)
    private Integer sex;
    /**
    * 出生日期
    */
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", format = "yyyy-MM-dd", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 3, importSort = 3)
    private Date birthday;
    /**
    * 政治面貌
    */
    @Excel(name = "政治面貌", replace = {"无_0", "团员_1", "党员_2"}, orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 4, importSort = 4)
    private String politicalStatus;
    /**
    * 年龄
    */
    @Excel(name = "年龄", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Integer age;
    /**
    * 籍贯
    */
    @Excel(name = "籍贯", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 6, importSort = 6)
    private String hometown;
    /**
    * 头像
    */
    @Excel(name = "头像", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 7, importSort = 7)
    private String avatatUrl;
    /**
    * 电话
    */
    @Excel(name = "电话", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 8, importSort = 8)
    private String phone;
    /**
    * 传真
    */
    @Excel(name = "传真", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 9, importSort = 9)
    private String fax;
    /**
    * 邮件
    */
    @Excel(name = "邮件", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 10, importSort = 10)
    private String email;
    /**
    * QQ
    */
    @Excel(name = "QQ", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 11, importSort = 11)
    private String qq;
    /**
    * 微信
    */
    @Excel(name = "微信", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 12, importSort = 12)
    private String wechat;
    /**
    * 博客
    */
    @Excel(name = "博客", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 13, importSort = 13)
    private String blog;
    /**
    * 邮编
    */
    @Excel(name = "邮编", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 14, importSort = 14)
    private String postCode;
    /**
    * 地址
    */
    @Excel(name = "地址", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 15, importSort = 15)
    private String address;
    /**
    * 部门/学院
    */
    @Excel(name = "部门/学院", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 16, importSort = 16)
    private String department;
    /**
    * 学位
    */
    @Excel(name = "学位", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 17, importSort = 17)
    private String degree;
    /**
    * 学科
    */
    @Excel(name = "学科", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 18, importSort = 18)
    private String subject;
    /**
    * 职位
    */
    @Excel(name = "职位", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 19, importSort = 19)
    private String position;
    /**
    * 职称
    */
    @Excel(name = "职称", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 20, importSort = 20)
    private String jobTitle;
    /**
    * 个人简介
    */
    @Excel(name = "个人简介", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 21, importSort = 21)
    private Object introduction;
    /**
    * 研究领域
    */
    @Excel(name = "研究领域", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 22, importSort = 22)
    private Object researchAreas;
    /**
    * 所属学院
    */
    @Excel(name = "所属学院", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 23, importSort = 23)
    private Integer unitId;
    /**
    * 所属学校
    */
    @Excel(name = "所属学校", orderNum = "1", width = 15)
    @ExcelAttributes(exportSort = 24, importSort = 24)
    private Integer schoolId;

    @ExcelAttributes(importSort = 999)
    private Long peopleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getAvatatUrl() {
        return avatatUrl;
    }

    public void setAvatatUrl(String avatatUrl) {
        this.avatatUrl = avatatUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Object getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Object introduction) {
        this.introduction = introduction;
    }

    public Object getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(Object researchAreas) {
        this.researchAreas = researchAreas;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

}