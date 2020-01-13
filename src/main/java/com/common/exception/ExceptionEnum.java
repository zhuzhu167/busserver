package com.common.exception;

import lombok.Getter;

/**
 * @author liangzhu
 * @title: ExceptionEnum
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0919:11
 */
@Getter
public enum ExceptionEnum {
    MissingServletRequestParameterException(400, "需传递的参数为空"),
    DuplicateKeyException(400, "该数据已经存在"),
    NullPointerException(400, "无可操作数据，受影响记录数为0"),
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
    public static ExceptionEnum isEnumDefined(String e) {
        String exception = e.substring(e.lastIndexOf(".") + 1);
        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (exception.equals(exceptionEnum.toString())) {
                return exceptionEnum;
            }
        }
        return UNKNOW_ERROR;
    }
}
