package cuit.hyl.graduation.project_ui.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 学校(School)实体类
 *
 * @author makejava
 * @since 2020-04-20 17:07:00
 */
@Data
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



}