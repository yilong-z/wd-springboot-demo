package com.wd.demo.service.Impl;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.wd.demo.dao.ZUserDao;
import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wd.demo.dao.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class userServiceImpl  implements userService {

    @Autowired
    ZUserDao ZUserDao;

    ResultEntity ResultEntity;


    @Override
    public PageInfo<ZUserEntity> user_ALL(int page, int pagesize, ZUserEntity ZUserEntity) {
        PageHelper.startPage(page,pagesize);//分页的插件 分页
        //查询所有的用户信息
        List<ZUserEntity> list =ZUserDao.userall(ZUserEntity);
        PageInfo<ZUserEntity> pageInfoUserList=new PageInfo<ZUserEntity>(list);

        return pageInfoUserList;

    }

    @Override
    public ResultEntity deleteUserByIds(String id) {
            if (ZUserDao.deleteUserById(id)>0){
                ResultEntity=new ResultEntity(200,"成功");
            }else {
                ResultEntity=new ResultEntity(202,"失败");
            }
        return ResultEntity;
    }

    @Override
    public ZUserEntity QueryUserByUserName(String username) {
        ZUserEntity z=new ZUserEntity();
        z.setUsername(username);

        return ZUserDao.QueryUserByUserName(z);
    }

    @Override
    public List<ZUserEntity> queryUser() {
        return ZUserDao.queryUser();
    }
}
