package com.wd.demo.dao;

import com.wd.demo.po.ZUserEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZUserDao {

    int updateLoginTime(ZUserEntity zUserEntity);

    int adduser(ZUserEntity zUserEntity);

    //
    ZUserEntity selectuser(ZUserEntity zUserEntity);

    //根据用户查询用户信息
    List<ZUserEntity> userall(ZUserEntity ZUserEntity);

    //根据id删除用户
    int deleteUserById(String id);
    //当添加用户成功后，会查询用户id
    ZUserEntity getUserId(ZUserEntity user);

    //根据用户名查询用户信息
    ZUserEntity QueryUserByUserName(ZUserEntity ZUserEntity);

    //查询所有用户
    List<ZUserEntity> queryUser();
}
