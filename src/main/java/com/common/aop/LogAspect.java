package com.common.aop;

import com.common.exception.ExceptionEnum;
import com.common.result.Result;
import com.common.result.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangzhu
 * @title: HttpAspect
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1021:24
 */
@Aspect
public class LogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.*.controller.*.*(..))")
    public void log() {

    }

    /**
     * 执行方法前
     *
     * @param joinPoint
     * @return
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        LOGGER.info("---------------------------------LogAspect---------------------------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("id={}", request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}", joinPoint.getArgs());
    }

    /**
     * 方法执行成功后
     *
     * @param result
     * @return
     */
    @AfterReturning(pointcut = "log()", returning = "result")
    public void doAfterReturing(Result result) {
        LOGGER.info("response={}", result.toString());
    }
}