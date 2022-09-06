package com.hibernate.spring.aspect;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** CRMLoggingAspect */
@Aspect
@Component
public class CRMLoggingAspect {
  private final Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

  @Pointcut("execution(* com.hibernate.spring.controller.*.*(..))")
  private void pointCutControllerPackage() {}

  @Pointcut("execution(* com.hibernate.spring.dao.*.*(..))")
  private void pointCutDaoPackage() {}

  @Before("pointCutControllerPackage() || pointCutDaoPackage()")
  private void execBeforeAdvice(JoinPoint joinPoint) {
    logger.info("===> @Before is running on method: " + joinPoint.getSignature().toShortString());
    logger.info("Args: " + Arrays.asList(joinPoint.getArgs()));
  }

  @AfterReturning(
      pointcut = "pointCutControllerPackage() || pointCutDaoPackage()",
      returning = "result")
  public void execAfterReturningAdvice(JoinPoint joinPoint, Object result) {
    logger.info(
        "===> @AfterReturning is running on method: " + joinPoint.getSignature().toShortString());
    logger.info("Args: " + Arrays.asList(joinPoint.getArgs()));
  }
}
