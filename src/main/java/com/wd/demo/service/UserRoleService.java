package com.wd.demo.service;

import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.UserRoleEntity;
import com.wd.demo.po.ZUserEntity;

import java.util.List;

public interface UserRoleService {

    //查询用户和权限的信息
    List<UserRoleEntity> selectUserRole();

    //注册时 添加用户为员工
    ResultEntity insertUserRole(ZUserEntity ZUserEntity);

    //根据id查询角色用户信息
    UserRoleEntity QueryUserRoleById(Integer id);

    //修改角色用户信息
    ResultEntity UpdateUserRole(UserRoleEntity UserRoleEntity);
}
