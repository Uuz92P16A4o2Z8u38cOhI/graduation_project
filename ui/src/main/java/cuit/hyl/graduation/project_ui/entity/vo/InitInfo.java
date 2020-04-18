package cuit.hyl.graduation.project_ui.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InitInfo implements Serializable {

    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatatUrl;
    /**
     * 博客
     */
    private String blog;

    private String icon;


}
