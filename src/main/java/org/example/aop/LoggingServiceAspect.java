package org.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.Loggers.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggingServiceAspect {


    private Map<String, Object> cash;
    private final Logger logger;
    private final MessageSource messageSource;

    @Autowired
    public LoggingServiceAspect(Logger logger, MessageSource messageSource) {
        this.logger = logger;
        this.messageSource = messageSource;
        this.cash = new HashMap<>();
    }

    @Pointcut("within(org.example.Service.*)")
    public void anyServiceMethod(){}

    @Before("anyServiceMethod()")
    public void beforeAnyServiceMethod(JoinPoint joinPoint) {
        logger.print(messageSource.getMessage("application.aspect.serviceMethodInvocation",new Object[]{joinPoint.getSignature()},null));

    }



    @Pointcut("execution(* org.example.Service..find*(*))")
    public void hasInOutputValuesServiceMethod(){}


    @AfterReturning(value = "hasInOutputValuesServiceMethod()", returning = "result")
    public void afterReturningWithInOutputValuesServiceMethod(JoinPoint joinPoint, Object result){
        logger.print(messageSource.getMessage("application.aspect.inputOutputValuesServiceMethods",new Object[]{joinPoint.getSignature(),Arrays.toString(joinPoint.getArgs()),result},null));
    }


    @Around("hasInOutputValuesServiceMethod() && within(org.example.BookDAO.BookDao)")
    public Object addCashParam(ProceedingJoinPoint pjp) throws Throwable{
         var result = pjp.proceed();
        cash.put( Arrays.toString(pjp.getArgs()), result);
        logger.print(messageSource.getMessage("application.line",null,null));
        for(Map.Entry<String, Object> entry : cash.entrySet()) {
               logger.print(messageSource.getMessage("application.aspect.cash", new Object[]{entry.getKey(),entry.getValue()},null));
        }
        logger.print(messageSource.getMessage("application.line",null,null));
        return result;

    }


}
