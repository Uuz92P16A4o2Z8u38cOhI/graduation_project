package cuit.hyl.graduation.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PermissionTree implements Serializable {
    private Long id;
    /**
     * 父权限
     */
    private Long parentId;
    /**
     * 权限名称
     */
    private String name;

    private List<PermissionTree> children;
}
