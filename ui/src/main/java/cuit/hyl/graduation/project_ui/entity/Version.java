package cuit.hyl.graduation.project_ui.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Version)实体类
 *
 * @author makejava
 * @since 2020-05-05 15:58:38
 */
@Data
public class Version implements Serializable {
    private static final long serialVersionUID = 809215364866949731L;
    /**
    * id
    */
    private Long id;
    /**
    * 版本名称
    */
    private String name;
    /**
    * 版本标志
    */
    private String sign;

    private String remarks;
    
    private Long peopleId;
    /**
    * 创建时间
    */
    private Date time;


}