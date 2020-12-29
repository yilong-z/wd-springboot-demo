package com.wd.demo.service.Impl;

import com.wd.demo.dao.UserRoleDao;
import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.UserRoleEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao UserRoleDao;

    ResultEntity ResultEntity;
    @Override
    public List<UserRoleEntity> selectUserRole() {

        return UserRoleDao.selectUserRole();
    }

    @Override
    public ResultEntity insertUserRole(ZUserEntity user) {
        int i =UserRoleDao.insertUserRole(user);

            if (i > 0) {
                ResultEntity = new ResultEntity(200, "注册成功");
            } else {
                ResultEntity = new ResultEntity(201, "注册失败");
            }

        return ResultEntity;
    }

    @Override
    public UserRoleEntity QueryUserRoleById(Integer id) {
        UserRoleEntity userRoleEntity = UserRoleDao.QueryUserRoleById(id);
        return userRoleEntity;
    }

    @Override
    public ResultEntity UpdateUserRole(UserRoleEntity UserRoleEntity) {
        int i = UserRoleDao.UpdateUserRole(UserRoleEntity);
        if (i > 0) {
            ResultEntity = new ResultEntity(200, "修改成功");
        } else {
            ResultEntity = new ResultEntity(201, "修改失败");
        }
        return ResultEntity;
    }
}
