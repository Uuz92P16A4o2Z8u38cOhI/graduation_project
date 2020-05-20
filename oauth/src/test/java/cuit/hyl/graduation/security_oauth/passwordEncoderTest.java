package cuit.hyl.graduation.security_oauth;

import cuit.hyl.graduation.security_oauth.entity.TbUser;
import cuit.hyl.graduation.security_oauth.service.TbUserService;
import cuit.hyl.graduation.security_oauth.service.impl.TbUserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class passwordEncoderTest {
    public static void main(String[] args) {
        TbUserService tbUserService = new TbUserServiceImpl();
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
        String secret = new BCryptPasswordEncoder().encode("secret");
        String newpwd = "secret";
        boolean i = new BCryptPasswordEncoder().matches( newpwd,secret);
        System.out.println(i);
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//        System.out.println(new BCryptPasswordEncoder().encode("zhuren"));
//        System.out.println(new BCryptPasswordEncoder().encode("teacher"));
    }
}
// $2a$10$H8Hfub3ztZtScpsTa.r4Ouoggqse/dPC/HdBILoz/oAZHvVmhDVaO
// $2a$10$WaNbUMsonLsvV/t2tgOrheruS4wq/7L5yd12Yeyba5qn.uzcJ0/Ie