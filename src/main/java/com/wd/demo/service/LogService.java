package com.wd.demo.service;

import com.wd.demo.aop.LogEntity;

import java.util.List;

public interface LogService {
    //新增日志
    int insertLog(LogEntity LogEntity);

    //查询
    List<LogEntity> queryLog();
}
