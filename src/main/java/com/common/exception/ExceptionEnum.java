package com.common.exception;

import com.common.result.Result;
import com.common.result.ResultUtil;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @author liangzhu
 * @title: ExceptionEnum
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0919:11
 */
@Getter
public enum ExceptionEnum {
    DuplicateKeyException(400, "该数据已经存在"),
    NullPointerException(400, "无可操作数据，受影响记录数为0"),
    DataIntegrityViolationException(400, "传入参数与数据库定义的类型不一致"),
    SERVER_EXECUTION_ERROR(404, "服务器执行错误"),
    UNKNOW_ERROR(500, "未知错误"),
    ;

    private Integer code;

    private String msg;

     ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替
     *
     * @param e
     * @return
     */
    public static Result isEnumDefined(Exception e) {
        String eToString = e.getClass().toString();
        String exception = eToString.substring(eToString.lastIndexOf(".") + 1);
        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (exception.equals(exceptionEnum.toString())) {
                return ResultUtil.error(exceptionEnum);
            }
        }
        return ResultUtil.error(UNKNOW_ERROR);
    }

    /**
     * 确认错误为参数校验错误，把不通过的参数的错误信息提出并返回
     *
     * @param e
     * @return
     */
    public static Result isValidError(Exception e) {
        MethodArgumentNotValidException m = (MethodArgumentNotValidException) e;
        BindingResult bindingResult = m.getBindingResult();
        String errorMesssage = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getField() + ":" + fieldError.getDefaultMessage() + ",";
        }

        return ResultUtil.error(400, "参数错误", errorMesssage);

    }
}
