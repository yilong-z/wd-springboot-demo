package com.wd.demo.service;

import com.github.pagehelper.PageInfo;
import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;

import java.util.List;

public interface userService {

    //分页+模糊查询
    PageInfo<ZUserEntity> user_ALL(int page,int pagesize,ZUserEntity ZUserEntity);

    //根据id删除用户信息
    ResultEntity deleteUserByIds(String id);

    //根据用户名查询用户信息
    ZUserEntity QueryUserByUserName(String username);

    //查询所有用户
    List<ZUserEntity> queryUser();

}
