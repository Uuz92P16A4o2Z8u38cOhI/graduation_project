package cuit.hyl.graduation.sys.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表(TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-07 13:32:06
 */
@Mapper
public interface TbUserDao {

    List<TbUser> queryAllUser(JSONObject params);

    int insertUser(JSONObject params);

    int updateUser(JSONObject parans);

    int deleteUser(Long id);

    int multipleDeleteUser(Long[] id);

    int updatePasswordByEmail(String email, String password);
    Long checkEmail(String email);
}