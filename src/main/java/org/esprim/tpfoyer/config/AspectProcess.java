package org.esprim.tpfoyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class AspectProcess {
    @Before("execution(*org.esprim.tpfoyer." + "service.ChambreServiceImpl.*(..))")
    public void LohMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("**** Existing method" + methodName + ":");
    }
}

@Around("execution(*org.esprim.tpfoyer." + "service.ChambreServiceImpl.*(..))")
public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    try {
        Object result = joinPoint.proceed();
        return result;
    }finally {
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        log.info ("Metho[{}] execution time: {}");
    }
}

