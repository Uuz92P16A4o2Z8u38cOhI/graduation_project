package cuit.hyl.graduation.sys.dao;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.sys.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户表(TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-07 13:32:06
 */
@Mapper
public interface TbUserDao {

    @Select("SELECT * FROM graduation_authority.tb_user WHERE id = #{id}")
    TbUser queryById(@Param("id") Long id);

    List<TbUser> queryAllUser(JSONObject params);

    int insertUser(JSONObject params);

    int updateUser(JSONObject parans);

    int deleteUser(Long id);

    int multipleDeleteUser(Long[] id);

    int updatePasswordByEmail(String email, String password);
    Long checkEmail(String email);

    @Update("UPDATE graduation_authority.tb_user set `password` = #{password} where id = #{id}")
    int updatePassword(Long id, String password);
}