package cuit.hyl.graduation.project_ui.entity;

import java.io.Serializable;

/**
 * 科研活动项(ResearchItem)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:21:36
 */
public class ResearchItem implements Serializable {
    private static final long serialVersionUID = 326701147176534924L;
    /**
    * id
    */
    private Long id;
    
    private Object itemName;

    private String itemContent;
    
    private Long parentId;
    /**
    * 类型：1、研究领域2、论文成果、3、专利4、著作成果5、科研项目6、科研团队
    */
    private Integer type;


    public Long getId() {
        return id;
    }

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