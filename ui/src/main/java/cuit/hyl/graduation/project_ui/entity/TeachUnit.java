package cuit.hyl.graduation.project_ui.entity;

import java.io.Serializable;

/**
 * (TeachUnit)实体类
 *
 * @author makejava
 * @since 2020-02-04 19:48:03
 */
public class TeachUnit implements Serializable {
    private static final long serialVersionUID = -41850332556222032L;
    
    private Integer id;
    /**
    * 单位名称
    */
    private String name;
    /**
    * 单位编码
    */
    private String code;
    /**
    * 父id
    */
    private Integer parentId;
    /**
    * 所属学校编码
    */
    private Integer schoolCode;
    /**
    * 单位图标
    */
    private String icon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(Integer schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}