package com.ivankrn.springbootcourse.aspect;

import com.ivankrn.springbootcourse.config.InfoConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LimitingAspect {
    private Map<String, Integer> callsCount = new HashMap<>();
    @Autowired
    private InfoConfig infoConfig;

    @Around("within(@com.ivankrn.springbootcourse.aspect.Limit *)")
    public Object limitCallAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        if (!callsCount.containsKey(methodName)) {
            callsCount.put(methodName, 0);
        }
        if (callsCount.get(methodName) < infoConfig.getApiCallLimit()) {
            callsCount.put(methodName, callsCount.get(methodName) + 1);
            Object apiResponse = joinPoint.proceed();
            return apiResponse;
        } else {
            throw new CallLimitExceedingException();
        }
    }
}
