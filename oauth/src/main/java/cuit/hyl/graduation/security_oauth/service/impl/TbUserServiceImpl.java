package cuit.hyl.graduation.security_oauth.service.impl;

import cuit.hyl.graduation.security_oauth.entity.TbUser;
import cuit.hyl.graduation.security_oauth.dao.TbUserDao;
import cuit.hyl.graduation.security_oauth.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author makejava
 * @since 2019-12-07 13:32:07
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;


    @Override
    public List<TbUser> queryByUserName(String username) {
        return tbUserDao.queryByUserName(username);
    }

    @Override
    public List<TbUser> queryAllUser() {
        return tbUserDao.queryAllUser();
    }
}