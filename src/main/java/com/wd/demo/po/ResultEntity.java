package com.wd.demo.po;

public class ResultEntity {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public ResultEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
