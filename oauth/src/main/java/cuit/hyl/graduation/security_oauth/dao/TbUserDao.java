package cuit.hyl.graduation.security_oauth.dao;

import cuit.hyl.graduation.security_oauth.entity.TbUser;
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

    /**
     * 通过username查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    List<TbUser> queryByUserName(String username);

    List<TbUser> queryAllUser();
}