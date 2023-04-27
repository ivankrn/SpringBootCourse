package com.ivankrn.springbootcourse.aspect;

import com.ivankrn.springbootcourse.config.InfoConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LimitingAspect {

    private int callsCount;
    @Autowired
    private InfoConfig infoConfig;

    @Pointcut("within(@com.ivankrn.springbootcourse.aspect.Limit *)")
    public void beanAnnotatedWithLimitPointcut() {
    }

    @Around("beanAnnotatedWithLimitPointcut()")
    public Object limitCallAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        if (callsCount < infoConfig.getApiCallLimit()) {
            callsCount++;
            Object apiResponse = joinPoint.proceed();
            return apiResponse;
        } else {
            throw new CallLimitExceedingException();
        }
    }
}
