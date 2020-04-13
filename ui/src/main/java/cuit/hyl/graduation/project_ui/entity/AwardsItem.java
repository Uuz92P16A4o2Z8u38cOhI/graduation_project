package cuit.hyl.graduation.project_ui.entity;

import java.io.Serializable;

/**
 * 获奖项(AwardsItem)实体类
 *
 * @author makejava
 * @since 2020-04-10 10:01:46
 */
public class AwardsItem implements Serializable {
    private static final long serialVersionUID = -66254564270700962L;
    /**
    * id
    */
    private Long id;
    
    private Object item;
    
    private Long parentId;
    /**
    * 1、学术荣誉2、科研奖项3、其它获奖4、荣誉称号
    */
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}