package com.common.exception;

import com.common.exception.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liangzhu
 * @title: DescribeException
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0919:16
 */
@Getter
@Setter
public class DescribeException extends RuntimeException {

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     *
     * @param exceptionEnum
     */
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @param code
     */
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;

    }
}
