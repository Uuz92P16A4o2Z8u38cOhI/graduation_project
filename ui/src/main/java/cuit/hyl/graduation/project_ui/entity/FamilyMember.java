package cuit.hyl.graduation.project_ui.entity;

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
    private String name;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 出生日期
    */
    private Date birth;
    /**
    * 工作单位
    */
    private String job;
    /**
    * 政治面貌
    */
    private Integer politicalStatus;
    /**
    * 关系
    */
    private String relation;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 电话
    */
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