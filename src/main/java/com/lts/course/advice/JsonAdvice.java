package com.lts.course.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 *jsonP跨域,只支持GET请求
 */
@ControllerAdvice
public class JsonAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonAdvice() {
        super("callback");
    }
}
