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

    UNKNOW_ERROR(-1, "未知错误"),
    USER_NOT_FIND(-101, "用户不存在"),
    DUPLICATE_KET(1062,"数据已经存在"),
    SERVER_EXECUTION_ERROR(-2,"服务器执行错误")
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
