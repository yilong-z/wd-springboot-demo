package com.wd.demo.service;

import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;

public interface loginService {

    //登陆用户
    ResultEntity login(String login_name,String password);

    //添加用户
    ResultEntity adduser(ZUserEntity user);

    //当添加用户成功后，会查询用户id
    ZUserEntity getUserId(ZUserEntity user);
}
