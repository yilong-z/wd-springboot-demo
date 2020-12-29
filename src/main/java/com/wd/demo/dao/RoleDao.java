package com.wd.demo.dao;

import com.wd.demo.po.RoleEntity;

import java.util.List;

public interface RoleDao {
    //查询角色
    List<RoleEntity> QueryRole();
}
