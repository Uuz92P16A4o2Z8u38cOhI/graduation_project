package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.io.Serializable;

/**
 * 科研活动项(ResearchItem)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:21:36
 */
@Data
public class ResearchItem implements Serializable {
    private static final long serialVersionUID = 326701147176534924L;
    /**
    * id
    */
    private Long id;

    @Excel(name = "名称", orderNum = "1", width = 45)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String itemName;

    @Excel(name = "内容", orderNum = "2", width = 85)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private Object itemContent;
    
    private Long parentId;
    /**
    * 类型：1、研究领域2、论文成果、3、专利4、著作成果5、科研项目6、科研团队
    */
//    @Excel(name = "学校", replace = {"研究领域_1", "论文成果_2", "专利_3","著作成果_4","科研项目_5","科研团队_6"}, orderNum = "1", width = 25)
    private Integer type;



}