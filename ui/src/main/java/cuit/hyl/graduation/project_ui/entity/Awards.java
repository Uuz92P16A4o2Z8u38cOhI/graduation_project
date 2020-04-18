package cuit.hyl.graduation.project_ui.entity;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 获奖信息(Awards)实体类
 *
 * @author makejava
 * @since 2020-04-09 20:26:14
 */
@Data
public class Awards implements Serializable {
    private static final long serialVersionUID = -65572673573107950L;
    /**
    * id
    */
    private Long id;
    /**
    * 学术荣誉
    */
    private Long academicHonors;
    /**
    * 科研奖项
    */
    private Long scientificAwards;
    /**
    * 其它获奖
    */
    private Long otherAwards;


    /**
    * 荣誉称号
    */
    private Long honoraryTitle;

    private Long honorWall;
    @ExcelAttributes(importSort = 999)
    private Long peopleId;
    /**
    * 上传时间
    */
    private Date uploadTime;




}