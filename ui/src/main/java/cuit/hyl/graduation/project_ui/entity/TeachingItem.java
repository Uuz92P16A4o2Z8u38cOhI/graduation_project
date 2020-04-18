package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;

import java.io.Serializable;

/**
 * 教学活动项(TeachingItem)实体类
 *
 * @author makejava
 * @since 2020-04-09 17:44:27
 */
public class TeachingItem implements Serializable {
    private static final long serialVersionUID = -54710067029480336L;
    /**
    * id
    */
    private Long id;

    @Excel(name = "内容", orderNum = "2", width = 65)
    @ExcelAttributes(importSort = 0,exportSort = 0)
    private Object item;
    
    private Long parentId;
    /**
    * 类型：1、教学研究2、教学资源、3、教学成果
    */
    @Excel(name = "教学",replace = {"教学研究_1", "教学资源_2", "教学成果_3"}, orderNum = "1", width = 15)
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