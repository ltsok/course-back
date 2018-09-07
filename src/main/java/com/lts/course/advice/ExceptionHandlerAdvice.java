package com.lts.course.advice;

import com.lts.course.exception.ResultException;
import com.lts.course.utils.Result;
import com.lts.course.utils.ResultCode;
import com.lts.course.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统异常处理
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * handleIllegalParamException
     * @param e e
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return ResultUtils.warn(ResultCode.PARAMETER_ERROR, tips);
    }

    /**
     * handleResultException
     * @param e e
     * @param request request
     * @return Result
     */
    @ExceptionHandler(ResultException.class)
    public Result handleResultException(ResultException e, HttpServletRequest request) {
        return ResultUtils.warn(e.getResultCode());
    }

    /**
     * handleException
     * @param e e
     * @param request request
     * @return  Result
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        logger.error(e.toString());
        return ResultUtils.warn(ResultCode.WEAK_NET_WORK);
    }

}
