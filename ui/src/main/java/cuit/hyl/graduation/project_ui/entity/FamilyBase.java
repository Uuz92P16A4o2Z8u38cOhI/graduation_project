package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.util.Date;
import java.io.Serializable;

/**
 * 家庭情况_基础(FamilyBase)实体类
 *
 * @author makejava
 * @since 2020-04-09 16:29:14
 */
public class FamilyBase implements Serializable {
    private static final long serialVersionUID = 697277860571375369L;
    /**
    * id
    */
    private Long id;
    /**
    * 家庭人口
    */
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private Integer population;
    /**
    * 家庭地址
    */
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String address;

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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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