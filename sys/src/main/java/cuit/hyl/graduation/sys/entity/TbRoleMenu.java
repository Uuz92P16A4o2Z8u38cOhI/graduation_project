package cuit.hyl.graduation.sys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TbRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-04-23 10:19:45
 */
@Data
public class TbRoleMenu implements Serializable {
    private static final long serialVersionUID = 358388631863632370L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;



}