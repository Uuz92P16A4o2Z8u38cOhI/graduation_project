package cuit.hyl.graduation.sys.service;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbUser;

import java.util.List;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2019-12-07 13:32:07
 */
public interface TbUserService {

    List<TbUser> queryAllUser(JSONObject params);

    int insertUser(JSONObject params);

    int updateUser(JSONObject parans);

    int deleteUser(Long id);

    int multipleDeleteUser(Long[] id);
}