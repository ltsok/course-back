package com.lts.course.utils;

public enum ResultCode {

    SUCCESS(0, "请求成功"),
    PARAMETER_ERROR(1, "参数不合法");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
