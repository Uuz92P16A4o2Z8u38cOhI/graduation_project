package cuit.hyl.graduation.project_ui.entity;
import	java.util.List;

import lombok.Data;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2019-12-26 15:27:54
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 251821039876898603L;
    /**
    * id
    */
    private Long id;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 父级id
    */
    private Integer parentId;
    /**
    * 路径
    */
    private String path;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 编码
    */
    private String code;
    /**
    * 图标
    */
    private String icon;
    /**
     * 子菜单
     */
    private List<Menu> children;
}