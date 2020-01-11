package com.common.aop;

import com.common.exception.ExceptionHandle;
import com.common.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
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
@Component
public class LogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.*.service.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("---------------------------------doBefore---------------------------------");
        System.out.println("url=" + request.getRequestURL());
        System.out.println("method=" + request.getMethod());
        System.out.println("class.method=" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("args=" + joinPoint.getArgs());
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


    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if (result == null) {
            return proceedingJoinPoint.proceed();
        } else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()", returning = "object")//打印输出结果
    public void doAfterReturing(Object object) {
        System.out.println("---------------------------------doAfterReturing---------------------------------\n" + object.toString());
        LOGGER.info("response={}", object.toString());
    }

    @AfterThrowing(throwing = "ex", pointcut = "log()")
    public void doAfterThrowing(Throwable ex) {
        LOGGER.info("response={}", ex.toString());
        System.out.println("---------------------------------doAfterThrowing---------------------------------\n" + ex);
    }
}