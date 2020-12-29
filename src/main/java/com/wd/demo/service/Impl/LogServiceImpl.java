package com.wd.demo.service.Impl;

import com.wd.demo.aop.LogEntity;
import com.wd.demo.dao.LogDao;
import com.wd.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao LogDao;

    @Override
    public int insertLog(LogEntity LogEntity) {
        return LogDao.insertLog(LogEntity);
    }

    @Override
    public List<LogEntity> queryLog() {
        return LogDao.queryLog();
    }
}
