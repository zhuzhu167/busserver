package com.common.result;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liangzhu
 * @title: Result
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0919:08
 */
@Getter
@Setter
public class Result<T> {
    //    error_code 状态值：0 为成功，其他数值代表失败
    private Integer status;

    //    error_msg 错误信息，若status0为时，为success
    private String msg;

    //    content 返回体报文的出参，使用泛型兼容不同的类型
    private T data;

    public Result() {

    }

    public Result(Result result) {
        this.status = result.status;
        this.msg = result.msg;
        this.data = (T) result.data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
