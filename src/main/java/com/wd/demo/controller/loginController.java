package com.wd.demo.controller;

import com.wd.demo.po.ResultEntity;
import com.wd.demo.po.ZUserEntity;
import com.wd.demo.service.Impl.UserRoleServiceImpl;
import com.wd.demo.service.Impl.loginServiceImpl;
import com.wd.demo.utils.MD5Util;

import com.wd.demo.utils.codeutil.IVerifyCodeGen;
import com.wd.demo.utils.codeutil.SimpleCharVerifyCodeGenImpl;
import com.wd.demo.utils.codeutil.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class loginController {


    @Autowired
    private loginServiceImpl loginServiceImpl;

    @Autowired
    private UserRoleServiceImpl UserRoleServiceImpl;


    private ResultEntity ResultEntity;

    /*
    * 添加用户信息
    * */
    @RequestMapping("/adduser")
    public String adduser(ZUserEntity user,Model model){

        user.setGenTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        String pass = MD5Util.string2MD5(user.getPassword());
        user.setPassword(pass);
        loginServiceImpl.adduser(user);
        ZUserEntity userId = loginServiceImpl.getUserId(user);
        ResultEntity =UserRoleServiceImpl.insertUserRole(userId);
        if (ResultEntity.getCode()==200){
            return "Login";

        }else if (ResultEntity.getCode()==202){
            model.addAttribute("msg","用户名存在，注册失败");
        }else{
            model.addAttribute("msg","注册失败");
        }
        return "admin/adduser";
    }

    @RequestMapping("/loginIn")
    public String Login(HttpServletRequest request, @RequestParam String login_name, @RequestParam String password, @RequestParam String code, Model model){
        ResultEntity=loginServiceImpl.login(login_name,MD5Util.string2MD5(password));
        HttpSession session1 = request.getSession();
        session1.setAttribute("username",login_name);
        //创建session
        HttpSession session=request.getSession();
        //判断验证码是否一致
        String trueCode=(String)session.getAttribute("VerifyCode");
        if (!trueCode.toLowerCase().equals(code.toLowerCase())) {//不区分大小写判断输入的验证码和真实的验证码是否一致
            model.addAttribute("msg","验证码不正确，请重新输入");
            return "Login";
        }

        if (ResultEntity.getCode()==200){
            model.addAttribute("loginName",login_name);
        }else{
            model.addAttribute("msg","用户或密码错误");
            return "Login";
        }
        return  "index";
    }

    /*
     * 获取验证码
     * */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
//            LOGGER.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
//            LOGGER.info("", e);
            System.out.println("异常处理");
        }
    }

    /*
    * 定义登陆页面
    * */
    @RequestMapping("/zyl_oa")
    public String index(HttpServletRequest request){
        return "Login";
    }

    /*定义注册页面*/
    @RequestMapping("/user")
    public String user(){
        return "admin/adduser";
    }




    @RequestMapping("/userall")
    public String auser(){
        return "admin/userall";
    }
}
