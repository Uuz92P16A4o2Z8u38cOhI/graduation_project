package cuit.hyl.graduation.project_ui.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable {

    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * 注册邮箱
     */
    private String email;
}