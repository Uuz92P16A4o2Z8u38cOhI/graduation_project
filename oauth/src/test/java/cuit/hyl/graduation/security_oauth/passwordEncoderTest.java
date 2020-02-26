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
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().encode("zhuren"));
        System.out.println(new BCryptPasswordEncoder().encode("teacher"));
    }
}
