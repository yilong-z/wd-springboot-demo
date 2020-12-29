package com.wd.demo.aop;

import lombok.Data;

@Data
public class LogEntity {
    private int id;
    private String optype;
    private String content;
    private String loginname;
    private String time;

}
