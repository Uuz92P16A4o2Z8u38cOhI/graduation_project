package cuit.hyl.graduation.sys.entity;

import java.io.Serializable;

/**
 * 用户角色表(TbUserRole)实体类
 *
 * @author makejava
 * @since 2020-03-02 14:31:51
 */
public class TbUserRole implements Serializable {
    private static final long serialVersionUID = 253827236198250045L;
    
    private Long id;
    /**
    * 用户 ID
    */
    private Long userId;
    /**
    * 角色 ID
    */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}