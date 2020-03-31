package com.common.result;

import com.common.exception.ExceptionEnum;

/**
 * @author liangzhu
 * @title: ResultUtil
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0919:13
 */
public class ResultUtil {
    /**
     * 返回成功，传入返回体具体出參
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     * @param i
     * @param 参数错误
     * @param 站点不存在
     */
    public static Result success(int i, String 参数错误, String 站点不存在) {
        return success(null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param 参数错误
     * @param msg
     * @return
     */
    public static Result error(Integer code, String 参数错误, String msg) {
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }



    /**
     * 返回异常信息，在已知的范围内
     *
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum) {
        Result result = new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }

}
