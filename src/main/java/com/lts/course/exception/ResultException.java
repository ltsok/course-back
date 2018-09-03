package com.lts.course.exception;

import com.lts.course.utils.ResultCode;

/**
 * 请求返回异常
 */
public class ResultException extends RuntimeException{

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ResultException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }
}
