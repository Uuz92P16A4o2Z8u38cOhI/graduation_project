package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 授课信息(TeachingClass)实体类
 *
 * @author makejava
 * @since 2020-04-09 17:43:52
 */
@Data
public class TeachingClass implements Serializable {
    private static final long serialVersionUID = -56385170110860765L;
    /**
    * id
    */
    private Long id;
    /**
    * 类型 1、本科生，2、研究生
    */
    private Integer type;
    /**
    * 课程名称
    */
    @Excel(name = "课程名称", orderNum = "1", width = 25)
    @ExcelAttributes(importSort = 0,exportSort = 0)
    private String courseName;
    /**
    * 学年
    */
    @Excel(name = "学年", orderNum = "2", width = 25)
    @ExcelAttributes(importSort = 1,exportSort = 1)
    private String schoolYear;
    /**
    * 学期
    */
    @Excel(name = "学期", orderNum = "3", width = 25)
    @ExcelAttributes(importSort = 2,exportSort = 2)
    private Integer semester;
    /**
    * 学时
    */
//    @Excel(name = "学时", orderNum = "4", width = 15)
//    @ExcelAttributes(importSort = 3,exportSort = 3)
//    private Integer hours;
    @Excel(name = "理论学时", orderNum = "4", width = 15)
    @ExcelAttributes(importSort = 3,exportSort = 3)
    private Integer theoryHours;
    @Excel(name = "实践学时", orderNum = "4", width = 15)
    @ExcelAttributes(importSort = 3,exportSort = 3)
    private Integer practiceHours;
    /**
    * 学分
    */
    @Excel(name = "学分", orderNum = "5", width = 15)
    @ExcelAttributes(importSort = 4,exportSort = 4)
    private Double credit;
    /**
    * 课程号
    */
    @Excel(name = "课程号", orderNum = "6", width = 25)
    @ExcelAttributes(importSort = 5,exportSort = 5)
    private String courseNum;
    
    private Long classInfoId;

    private Long peopleId;

    private Timestamp uploadTime;

    private Integer version;


}