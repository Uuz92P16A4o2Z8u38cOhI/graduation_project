package cuit.hyl.graduation.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleTree implements Serializable {

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

    private List<RoleTree> children;
}
