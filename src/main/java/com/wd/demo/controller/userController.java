package com.wd.demo.controller;

import com.alibaba.fastjson.JSONException;

import com.github.pagehelper.PageInfo;

import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.Impl.userServiceImpl;

import com.wd.demo.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class userController {
    @Autowired
    userServiceImpl userServiceImpl;

    ResultEntity ResultEntity;


    /*
    * 查询所有的用户信息并进行分页处理
    * */
    @ResponseBody
    @RequestMapping("/user_all")
    public JsonObject userall(Model Model, ZUserEntity ZUserEntity, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) throws JSONException {

        PageInfo<ZUserEntity> pageInfolist=userServiceImpl.user_ALL(page,limit,ZUserEntity);

        JsonObject<ZUserEntity> jobj=new JsonObject();
        jobj.setCode(0);
        jobj.setCount(pageInfolist.getTotal());
        jobj.setMsg("ok");
        jobj.setData(pageInfolist.getList());

        return jobj;
    }

    @ResponseBody
    @RequestMapping("user/deleteUserById")
    public ResultEntity deleteUserById(String id){
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResultEntity= userServiceImpl.deleteUserByIds(id);
        if (ResultEntity.getCode()==200){
            System.out.println("成功");
            HttpSession session=request.getSession();
            session.setAttribute("optype","删除用户操作");
        }else {
            System.out.println("失败");
        }
        return ResultEntity;
    }
}
