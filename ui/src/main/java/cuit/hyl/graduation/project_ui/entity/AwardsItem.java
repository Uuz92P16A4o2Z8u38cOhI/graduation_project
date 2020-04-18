package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.io.Serializable;

/**
 * 获奖项(AwardsItem)实体类
 *
 * @author makejava
 * @since 2020-04-10 10:01:46
 */
@Data
public class AwardsItem implements Serializable {
    private static final long serialVersionUID = -66254564270700962L;
    /**
    * id
    */
    private Long id;

    @Excel(name = "名称", orderNum = "1", width = 45)
    @ExcelAttributes(importSort = 0,exportSort = 0)
    private String itemName;

    @Excel(name = "内容", orderNum = "1", width = 85)
    @ExcelAttributes(importSort = 1,exportSort = 1)
    private Object itemContent;
    
    private Long parentId;
    /**
    * 1、学术荣誉2、科研奖项3、其它获奖4、荣誉称号
    */
//    @Excel(name = "学校", replace = {"学术荣誉_1", "科研奖励_2", "其它获奖_3","荣誉称号_4"}, orderNum = "1", width = 25)
    private Integer type;


}