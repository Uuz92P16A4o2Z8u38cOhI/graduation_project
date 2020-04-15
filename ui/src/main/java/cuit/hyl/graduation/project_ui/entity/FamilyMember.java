package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.util.Date;
import java.io.Serializable;

/**
 * 家庭成员(FamilyMember)实体类
 *
 * @author makejava
 * @since 2020-04-09 16:31:46
 */
public class FamilyMember implements Serializable {
    private static final long serialVersionUID = 318910794978184710L;
    /**
    * id
    */
    private Long id;
    /**
    * 头像
    */
    private Integer avatarType;
    /**
    * 姓名
    */
    @Excel(name = "姓名", orderNum = "1", width = 25)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String name;
    /**
    * 性别
    */
    @Excel(name = "性别", orderNum = "2", replace = {"男_1","女_0"}, width = 25)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private Integer sex;
    /**
    * 出生日期
    */
    @Excel(name = "出生日期", format = "yyyy-MM-dd", orderNum = "3", width = 25)
    @ExcelAttributes(exportSort = 2, importSort = 2)
    private Date birth;
    /**
    * 工作单位
    */
    @Excel(name = "工作单位", orderNum = "4", width = 25)
    @ExcelAttributes(exportSort = 3, importSort = 3)
    private String job;
    /**
    * 政治面貌
    */
    @Excel(name = "政治面貌", orderNum = "5", width = 25)
    @ExcelAttributes(exportSort = 4, importSort = 4)
    private Integer politicalStatus;
    /**
    * 关系
    */
    @Excel(name = "关系", orderNum = "6", width = 25)
    @ExcelAttributes(exportSort = 5, importSort = 5)
    private String relation;
    /**
    * 邮箱
    */
    @Excel(name = "邮箱", orderNum = "7", width = 25)
    @ExcelAttributes(exportSort = 6, importSort = 6)
    private String email;
    /**
    * 电话
    */
    @Excel(name = "电话", orderNum = "8", width = 25)
    @ExcelAttributes(exportSort = 7, importSort = 7)
    private String phone;
    
    private Long baseId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvatarType() {
        return avatarType;
    }

    public void setAvatarType(Integer avatarType) {
        this.avatarType = avatarType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

}