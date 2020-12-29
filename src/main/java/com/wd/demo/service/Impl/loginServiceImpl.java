package com.wd.demo.service.Impl;

import com.wd.demo.dao.ZUserDao;
import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("loginService")
public class loginServiceImpl implements loginService {
    @Autowired
    private ZUserDao ZUserDao;

    /*登陆业务*/
    private ResultEntity ResultEntity;
    @Override
    public ResultEntity login(String login_name, String password) {
        ZUserEntity z=new ZUserEntity();
        z.setPassword(password);
        z.setLoginName(login_name);
        z.setLastLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int i =ZUserDao.updateLoginTime(z);
        if (i>0){
            ResultEntity=new ResultEntity(200,"登陆成功");
        }else {
            ResultEntity=new ResultEntity(201,"用户名或密码错误");
        }

        return ResultEntity;
    }

    /*添加用户业务*/
    @Override
    public ResultEntity adduser(ZUserEntity user) {
        ZUserEntity ZUserEntity =ZUserDao.selectuser(user);
        if (ZUserEntity==null) {
            int i = ZUserDao.adduser(user);
            if (i > 0) {
                ResultEntity = new ResultEntity(200, "注册成功");
            } else {
                ResultEntity = new ResultEntity(201, "注册失败");
            }
        }else {
            ResultEntity = new ResultEntity(202, "用户名已存在");
        }
        return ResultEntity;
    }

    @Override
    public ZUserEntity getUserId(ZUserEntity user) {
        ZUserEntity userEntity =ZUserDao.getUserId(user);
        return userEntity;
    }
}
