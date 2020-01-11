package com.common.exception;

import com.common.result.Result;
import com.common.result.ResultUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;


/**
 * @author liangzhu
 * @title: ExceptionHandle
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1021:26
 */
@ControllerAdvice
@ResponseStatus
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Result exceptionGet(Exception e) {
        System.out.println("---------------------------------全局异常捕捉---------------------------------");
        LOGGER.error("【系统异常】{}", e);
        Result result = new Result();
        if (e instanceof DuplicateKeyException) {
            result = ResultUtil.error(ExceptionEnum.DUPLICATE_KET);
        } else if (e instanceof RuntimeException || e instanceof RuntimeException) {
            result = ResultUtil.error(ExceptionEnum.SERVER_EXECUTION_ERROR);
        } else {
            result = ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
        return result;
    }
}
