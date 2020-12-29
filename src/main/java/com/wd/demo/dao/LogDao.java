package com.wd.demo.dao;

import com.wd.demo.aop.LogEntity;

import java.util.List;

public interface LogDao {
    //新增日志
    int insertLog(LogEntity LogEntity);

    //查询所有
    List<LogEntity> queryLog();
}
