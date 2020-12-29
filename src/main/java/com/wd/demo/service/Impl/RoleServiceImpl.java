package com.wd.demo.service.Impl;

import com.wd.demo.dao.RoleDao;
import com.wd.demo.po.RoleEntity;
import com.wd.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao RoleDao;

    @Override
    public List<RoleEntity> QueryRole() {

        return RoleDao.QueryRole();
    }
}
