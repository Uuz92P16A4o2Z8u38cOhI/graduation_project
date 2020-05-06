package cuit.hyl.graduation.project_ui.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 家庭情况_基础(FamilyBase)实体类
 *
 * @author makejava
 * @since 2020-04-09 16:29:14
 */
@Data
public class FamilyBase implements Serializable {
    private static final long serialVersionUID = 697277860571375369L;
    /**
    * id
    */
    private Long id;
    /**
    * 家庭人口
    */
    @Excel(name = "家庭人口", orderNum = "1", width = 25, needMerge = true)
    @ExcelAttributes(exportSort = 0, importSort = 0)
    private Integer population;
    /**
    * 家庭地址
    */
    @Excel(name = "家庭地址", orderNum = "3", width = 55, needMerge = true)
    @ExcelAttributes(exportSort = 1, importSort = 1)
    private String address;

    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    /**
    * 上传时间
    */
    private Date uploadTime;

    /**
     * 家庭成员
     */
    @ExcelCollection(name = "家庭成员", orderNum = "2")
    private List<FamilyMember> familyMembers;

    private Long version;
}