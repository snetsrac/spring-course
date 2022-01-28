package com.snetsrac.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
    
    // Set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Set up pointcut declarations
    @Pointcut("execution(* com.snetsrac.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.snetsrac.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.snetsrac.springdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    // Add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        String[] argStrings = new String[args.length];

        for (int i = 0; i < args.length; i++) {
            argStrings[i] = args[i] == null ? "null" : args[i].toString();
        }

        logger.warning("calling method: " + joinPoint.getSignature().toShortString() +
            " with args: (" + String.join(", ", argStrings) + ")");
    }

    // Add @AfterReturning advice
    @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "returnValue"
    )
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        logger.warning("method returning: " + joinPoint.getSignature().toShortString() +
            " with value: " + returnValue);
    }
}
