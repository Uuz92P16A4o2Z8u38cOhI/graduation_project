package cuit.hyl.graduation.security_oauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (TbMenu)实体类
 *
 * @author makejava
 * @since 2020-02-23 19:25:02
 */
@Data
public class TbMenu implements Serializable {
    private static final long serialVersionUID = -78265012862271425L;
    /**
    * id
    */
    private Integer id;
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
    * 排序
    */
    private Integer odr;

    private List<TbMenu> children;

}