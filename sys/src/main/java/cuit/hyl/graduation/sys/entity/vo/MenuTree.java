package cuit.hyl.graduation.sys.entity.vo;

import cuit.hyl.graduation.sys.entity.TbMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuTree implements Serializable {
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
     * 排序
     */
    private Integer odr;

    private List<MenuTree> children;
}
