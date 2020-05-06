package cuit.hyl.graduation.security_oauth.entity;

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
     * 密码，加密存储
     */
    private String password;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * 注册邮箱
     */
    private String email;

    private Date created;

    private Date updated;
}
