package com.wd.demo.controller;

import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.RoleEntity;
import com.wd.demo.po.UserRoleEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.Impl.RoleServiceImpl;
import com.wd.demo.service.Impl.UserRoleServiceImpl;
import com.wd.demo.service.Impl.userServiceImpl;
import com.wd.demo.utils.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;


@Controller
public class roleController {
    @Autowired
    UserRoleServiceImpl UserRoleServiceImpl;

    @Autowired
    RoleServiceImpl RoleServiceImpl;
    @Autowired
    userServiceImpl userServiceImpl;


    //查询角色信息
    @ResponseBody
    @RequestMapping("role/UserRoleAll")
    public JsonObject UserRoleSelect(){
        JsonObject list=new JsonObject();
        list.setData(UserRoleServiceImpl.selectUserRole());
        list.setMsg("ok");
        list.setCode(0);
        list.setCount((long) 200);
        return list;
    }
    //修改角色
    @RequestMapping("role/updateRoleToRole")
    public String updateRoleToRole(UserRoleEntity UserRoleEntity){
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserRoleServiceImpl.UpdateUserRole(UserRoleEntity);
        HttpSession session=request.getSession();
        session.setAttribute("optype","修改操作");
        return "admin/role";
    }


    //修改角色页面
    @RequestMapping("role/update")
    public String queryUserRole(@RequestParam("username") String username, Model Model){
        ZUserEntity userEntity = userServiceImpl.QueryUserByUserName(username);
        UserRoleEntity userRoleEntity = UserRoleServiceImpl.QueryUserRoleById(userEntity.getZuId());
        List<RoleEntity> roleEntities = RoleServiceImpl.QueryRole();
        Model.addAttribute("UserRole",userRoleEntity);
        Model.addAttribute("RoleList",roleEntities);
        return "admin/updateRole";
    }
    //权限页面的跳转
    @RequestMapping("role/index")
    public String roleindex(){

        return "admin/role";
    }
}
