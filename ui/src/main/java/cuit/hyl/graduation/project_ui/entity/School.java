package cuit.hyl.graduation.project_ui.entity;

import java.io.Serializable;

/**
 * 学校(School)实体类
 *
 * @author makejava
 * @since 2020-04-20 17:07:00
 */
public class School implements Serializable {
    private static final long serialVersionUID = -42494150148989538L;
    
    private Long id;
    /**
    * 学校名称
    */
    private String name;
    /**
    * 学校编码
    */
    private Integer code;
    /**
    * 学校地址
    */
    private String address;
    /**
    * 学校图标
    */
    private String icon;


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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}