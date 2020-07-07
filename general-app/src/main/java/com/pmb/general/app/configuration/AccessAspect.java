package com.pmb.general.app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AccessAspect {
    private static final String FORMAT_USER = "%s|%s|%s|%s|%s";
    private static final String FORMAT_NO_USER = "%s|%s|%s|%s";

    @Pointcut(value = "execution(* com.pmb.general.web.controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Around(value = "controllerPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String name = joinPoint.getTarget().getClass().getSimpleName();
        String functionName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            long take = System.currentTimeMillis() - start;
            int status = 3;
            log.info(String.format(FORMAT_NO_USER, name, functionName, status, take));
        }
        return proceed;
    }
}
