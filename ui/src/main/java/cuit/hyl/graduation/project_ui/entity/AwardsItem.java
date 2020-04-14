package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

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

    public Object getItemName() {
        return itemName;
    }

    public void setItemName(Object itemName) {
        this.itemName = itemName;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    @ExcelAttributes(importSort = 0,exportSort = 0)
    private Object itemName;

    @ExcelAttributes(importSort = 1,exportSort = 1)
    private String itemContent;
    
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