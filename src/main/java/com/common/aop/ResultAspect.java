package com.common.aop;

import com.common.exception.ExceptionEnum;
import com.common.result.Result;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * @author liangzhu
 * @title: ResultAspect
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1310:35
 */
@Aspect
public class ResultAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(public * com.*.service.impl.*.*(..))")
    public void pCut() {

    }

    /**
     * 方法执行成功后
     *
     * @param result
     * @return
     */
    @AfterReturning(pointcut = "pCut()", returning = "result")
    public void doAfterReturing(Result result) {
        if (result.getData().toString().equals("null")||result.getData().toString().equals("0")) {
            result.setStatus(ExceptionEnum.NullPointerException.getCode());
            result.setMsg(ExceptionEnum.NullPointerException.getMsg());
            ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            res.getResponse().setStatus(result.getStatus());
        }
    }
}
