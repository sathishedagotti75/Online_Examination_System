package com.sathish.demo.aspect;
import org.aspectj.lang.JoinPoint;import org.aspectj.lang.annotation.*;import org.springframework.stereotype.Component;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
@Aspect @Component public class LoggingAspect {
 private static final Logger log=LoggerFactory.getLogger(LoggingAspect.class);
 @Before("execution(* com.sathish.demo.service..*(..))") public void before(JoinPoint p){log.info("Calling {}",p.getSignature().toShortString());}
 @AfterThrowing(pointcut="execution(* com.sathish.demo.service..*(..))",throwing="ex") public void error(JoinPoint p,Throwable ex){log.error("Error in {}: {}",p.getSignature().toShortString(),ex.getMessage());}
}
