package com.snetsrac.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Pointcut("execution(* com.snetsrac.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeDaoPackageAdvice() {
        System.out.println(getClass() + ": inside beforeDaoPackageAdvice()");
    }

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + ": inside beforeAddAccountAdvice()");
    }

    @Pointcut("execution(* get*(..)) && execution(* set*(..))")
    private void forNotGettersAndSetters() {}

    @Before("forDaoPackage() && !forNotGettersAndSetters()")
    public void comboAndJoinPointAdvice(JoinPoint joinPoint) {
        System.out.println(getClass() + ": inside comboAndJoinPointAdvice()");

        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        System.out.println((MethodSignature) signature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        
        System.out.println(getClass() + ": leaving comboAndJoinPointAdvice()");
    }
}
