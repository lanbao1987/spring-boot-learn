package com.guosen.spring.basic.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class AspectHandler {


    @Pointcut("execution(* com.guosen.spring.basic.controller.AopController.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        log.info("执行方法，method:[{}],class:[{}]", name, declaringTypeName);

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        log.info("请求地址，url：[{}],ip:[{}]", url, ip);
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        log.info("方法：[{}]执行完成", method);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, String result) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        log.info("方法：[{}]执行完成,返回[{}]", method, result);
        result += "aaabbbccc";
        log.info("方法：[{}]执行完成,返回增强[{}]", method, result + "增强");
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        log.info("方法around：[{}]执行完成,返回[{}]", method);
        Object obj = joinPoint.proceed();
        obj = "aaabbbccc";
        log.info("方法around：[{}]执行完成,返回增强[{}]", method);
        return obj;
    }

}
