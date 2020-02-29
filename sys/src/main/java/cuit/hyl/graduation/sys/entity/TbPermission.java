package cuit.hyl.graduation.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表(TbPermission)实体类
 *
 * @author makejava
 * @since 2019-12-07 13:47:37
 */
public class TbPermission implements Serializable {
    private static final long serialVersionUID = 874795164460647626L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
    * 父权限
    */
    private Long parentId;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 权限英文名称
    */
    private String enname;
    /**
    * 授权路径
    */
    private String url;
    /**
    * 备注
    */
    private String description;
    
    private Date created;
    
    private Date updated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}