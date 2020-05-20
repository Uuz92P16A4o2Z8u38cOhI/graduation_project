package cuit.hyl.graduation.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.dao.TbUserDao;
import cuit.hyl.graduation.sys.entity.TbUser;
import cuit.hyl.graduation.sys.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public TbUser queryById(Long id) {
        return this.tbUserDao.queryById(id);
    }

    @Override
    public List<TbUser> queryAllUser(JSONObject params) {
        return this.tbUserDao.queryAllUser(params);
    }

    @Override
    @Transactional
    public int insertUser(JSONObject params) {
        return this.tbUserDao.insertUser(params);
    }

    @Override
    @Transactional
    public int updateUser(JSONObject parans) {
        return this.tbUserDao.updateUser(parans);
    }

    @Override
    @Transactional
    public int deleteUser(Long id) {
        return this.tbUserDao.deleteUser(id);
    }

    @Override
    @Transactional
    public int multipleDeleteUser(Long[] id) {
        return this.tbUserDao.multipleDeleteUser(id);
    }

    @Transactional
    @Override
    public int updatePasswordByEmail(String email, String password) {
        return this.tbUserDao.updatePasswordByEmail(email, password);
    }

    @Override
    public Long checkEmail(String email) {
        return this.tbUserDao.checkEmail(email);
    }

    @Override
    public int updatePassword(Long id, String password) {
        return this.tbUserDao.updatePassword(id, password);
    }
}