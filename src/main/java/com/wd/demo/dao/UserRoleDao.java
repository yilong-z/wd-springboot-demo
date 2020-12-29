package com.wd.demo.dao;

import com.wd.demo.po.UserRoleEntity;
import com.wd.demo.po.ZUserEntity;

import java.util.List;

public interface UserRoleDao {

        //查询用户和角色的信息
        List<UserRoleEntity> selectUserRole();

        //添加用户角色表：角色为员工
        int insertUserRole(ZUserEntity ZUserEntity);

        //根据id查询角色用户信息
        UserRoleEntity QueryUserRoleById(Integer id);

        //修改角色用户信息
        int UpdateUserRole(UserRoleEntity UserRoleEntity);
}
