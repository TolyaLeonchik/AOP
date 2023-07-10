package com.site.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class AspectClass {

    @Pointcut(value = "execution(public * com.site.*.*())")
    void emptyMethod() {
    }

    @After("emptyMethod()")     //момент времени advice
    public void checkPointcut() {
        System.out.println("Pointcut work!");
    }


    @Before("execution(public * com.site.annotation.*.*())")
    public void checkBefore(JoinPoint joinPoint) {
        System.out.println("@Before " + " " + joinPoint.getSignature().getName());
    }

    @After(value = "execution(public * com.site.annotation.*.*())")
    public void checkAfter(JoinPoint joinPoint) {
        System.out.println("@After " + " " + joinPoint.getSignature().getName());
    }

    @Around(value = "within(com.site.annotation.*)")
    public Object checkAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around has started " + joinPoint.getSignature().getName());
        Object returnValue = joinPoint.proceed();
        System.out.println("@Around has ended " + joinPoint.getSignature().getName());
        return returnValue;
    }

    @AfterThrowing(value = "within(com.site.annotation.*)", throwing = "error")
    public void printAfterThrowing(Throwable error) {
        System.out.println(LocalTime.now() + " " + error.toString());
    }

    @AfterReturning(value = "within(com.site.annotation.*)", returning = "returningValue")
    public void printAfterReturning(Object returningValue) {
        System.out.println("Returning value: " + returningValue);
    }
}
