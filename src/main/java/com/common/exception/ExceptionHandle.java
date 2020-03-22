package com.common.exception;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * @author liangzhu
 * @title: ExceptionHandle
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1021:26
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 全局捕捉异常
     *
     * @param e
     * @param httpServletResponse
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Result exceptionGet(Exception e, HttpServletResponse httpServletResponse) {
        LOGGER.error("---------------------------------异常捕捉---------------------------------");
        LOGGER.error(e.getClass().toString());
        LOGGER.error(e.getMessage());
        Result result =new Result();
        if (e instanceof MethodArgumentNotValidException) {
            result = ExceptionEnum.isValidError(e);
        } else {
            result = ExceptionEnum.isEnumDefined(e);
        }
        httpServletResponse.setStatus(result.getStatus());
        return result;
    }
}
