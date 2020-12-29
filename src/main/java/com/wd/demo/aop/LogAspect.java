package com.wd.demo.aop;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wd.demo.dao.LogDao;
import com.wd.demo.service.Impl.LogServiceImpl;
import com.wd.demo.utils.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    LogServiceImpl LogServiceImpl;

    private String time;//开始时间
    private Class Clazz;//访问的类
    private Method Method;//访问的方法


    /*
    * 声明一个切入点 里面是execution表达式
    * */
   // @Pointcut("execution(public * com.wd.demo.controller.roleController.*(..))")
    @Pointcut("execution(public * com.wd.demo.controller.userController.deleteUserById(..))")
    private void aspect(){}

    @Pointcut("execution(public * com.wd.demo.controller.roleController.updateRoleToRole(..))")
    private void a(){}
    /*
    * 执行前的一些操作
    * */
    @AfterReturning("aspect()||a()")
    public void before(JoinPoint JoinPoint) throws NoSuchMethodException {
        time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Clazz=JoinPoint.getTarget().getClass();
        String MethodName = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();
        if (args==null||args.length==0) {
            Method=Clazz.getMethod(MethodName);//获取执行的方法
        }else {
            Class[] argsclasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argsclasses[i]=args[i].getClass();
            }
          //  Method=Clazz.getMethod(MethodName,argsclasses);
        }

        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request=requestAttributes.getRequest();
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("username");
        String optype= (String) session.getAttribute("optype");
        log.info("=====请求内容开始");
        log.info(time);
        log.info("optype="+optype);
        log.info("username="+username);
       // String requestMethod=request.getMethod();
      //  log.info("请求地址"+request.getRequestURI());
       // log.info("请求方式"+requestMethod);
        //log.info("请求类方法"+JoinPoint.getSignature());
        log.info("请求参数"+ Arrays.toString(JoinPoint.getArgs()));
        LogEntity logEntity=new LogEntity();
        logEntity.setLoginname(username);
        logEntity.setContent(Arrays.toString(JoinPoint.getArgs()));
        logEntity.setOptype(optype);
        logEntity.setTime(time);
        LogServiceImpl.insertLog(logEntity);
        log.info("=========请求内容结束");

    }
    /*
    * 在方法执行完后的操作
    * */
//    @AfterReturning(returning = "Object" ,pointcut = "aspect()")
//    public void methodAfterReturning(Object Object) throws JsonProcessingException {
//        System.out.println("+++++++++++返回内容");
//        System.out.println(ObjectMapper.writeValueAsString(Object));
//        System.out.println("+++++++++++返回内容结束");
//
//    }



}
