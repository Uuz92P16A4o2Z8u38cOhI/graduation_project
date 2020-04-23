package cuit.hyl.graduation.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表(TbRole)实体类
 *
 * @author makejava
 * @since 2020-02-03 20:24:07
 */
@Data
public class TbRole implements Serializable {
    private static final long serialVersionUID = 639786218736414937L;
    
    private Long id;
    /**
    * 父角色
    */
    private Long parentId;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 角色英文名称
    */
    private String enname;
    /**
    * 备注
    */
    private String description;
    
    private Date created;
    
    private Date updated;

    private Integer type;

}