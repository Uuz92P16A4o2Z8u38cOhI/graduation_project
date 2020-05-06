package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 教育经历(Education)实体类
 *
 * @author makejava
 * @since 2020-04-02 20:22:54
 */
@Data
public class Education implements Serializable {
    private static final long serialVersionUID = 890685807107640271L;
    /**
    * id
    */
    private Long id;
    /**
    * 学校
    */
    @Excel(name = "学校", orderNum = "1", width = 25)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private String schoole;
    /**
    * 学历
    */
    @Excel(name = "学历", orderNum = "2", width = 20)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String degree;
    /**
    * 专业
    */
    @Excel(name = "专业", orderNum = "3", width = 30)
    @ExcelAttributes(exportSort = 2, importSort = 2)
    private String subject;
    /**
    * 开始时间
    */
    @Excel(name = "开始时间", format = "yyyy-MM-dd", orderNum = "4", width = 25)
    @ExcelAttributes(exportSort = 3, importSort = 3)
    private Date startTime;
    /**
    * 结束时间
    */
    @Excel(name = "结束时间", format = "yyyy-MM-dd", orderNum = "5", width = 25)
    @ExcelAttributes(exportSort = 4, importSort = 4)
    private Date endTime;

    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    /**
    * 上传时间
    */
//    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Date uploadTime;
    /**
    * 版本号
    */
    @Excel(name = "版本号", orderNum = "6", width = 25)
    @ExcelAttributes(exportSort = 5, importSort = 5)
    private Long version;

}