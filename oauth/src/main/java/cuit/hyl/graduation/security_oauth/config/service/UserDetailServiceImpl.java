package cuit.hyl.graduation.security_oauth.config.service;

import com.alibaba.fastjson.JSON;
import cuit.hyl.graduation.security_oauth.entity.TbPermission;
import cuit.hyl.graduation.security_oauth.entity.TbUser;
import cuit.hyl.graduation.security_oauth.service.TbPermissionService;
import cuit.hyl.graduation.security_oauth.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 查询用户信息
        TbUser tbUser = tbUserService.queryByUserName(s).get(0);
        System.out.println(tbUser.toString());
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = tbPermissionService.queryByUserId(tbUser.getId());
            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        TbUser TbUserInfo = new TbUser();
        TbUserInfo.setId(tbUser.getId());
        TbUserInfo.setUsername(tbUser.getUsername());
        TbUserInfo.setEmail(tbUser.getEmail());
        TbUserInfo.setPhone(tbUser.getPhone());
        String userInfo = JSON.toJSONString(TbUserInfo);
        // 由框架完成认证工
        return new User(userInfo, tbUser.getPassword(), grantedAuthorities);
    }
}
