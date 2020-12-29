package com.wd.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.Impl.LogServiceImpl;
import com.wd.demo.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import com.wd.demo.service.Impl.userServiceImpl;
@Controller
public class indexController {

    @Autowired
    userServiceImpl userServiceImpl;

    @Autowired
    LogServiceImpl LogServiceImpl;

    /*对柱状图进行数据传输*/
    @ResponseBody
    @RequestMapping("/member/getData4")
    public JSONObject getData4(){
        JSONObject data=new JSONObject();
        List<Integer> mapValue=new ArrayList<>();
        List<String> mapName=new ArrayList<>();
        List<ZUserEntity> ZUserList=userServiceImpl.queryUser();
        for (ZUserEntity a: ZUserList) {
            mapValue.add(a.getCount());
            mapName.add(a.getUsername());
        }
        data.put("mapValue",mapValue);
        data.put("mapName",mapName);
        return data;
    }
    //显示log页面信息
    @ResponseBody
    @RequestMapping("logAll")
    public JsonObject logall(){
        JsonObject list=new JsonObject();
        list.setData(LogServiceImpl.queryLog());
        list.setMsg("ok");
        list.setCode(0);
        list.setCount((long) 200);
        return list;
    }

    /*跳转到用户登陆次数页面*/
    @RequestMapping("/UserCount")
    public String UserCount(){
        return "admin/UserEchartCount";
    }

    //跳转日志页面
    @RequestMapping("/log")
    public String loghtml(){
        return "admin/log";
    }

    //显示404页面

    //显示报错页面
}
