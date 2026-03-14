package com.example.appdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * @author huangmh 2026/03/11
     * @Describle:
     * <p>定义切入点：对要拦截的方法进行定义与限制，如包、类</p>
     * <p>1、execution(public * *(..)) 任意的公共方法</p>
     * <p>2、execution（* set*（..）） 以set开头的所有的方法</p>
     * <p>3、execution（* com.example.appdemo.controller.*（..））类里的所有的方法</p>
     * <p>4、execution（* com.example.appdemo.controller.*.*（..））包下的所有的类的所有的方法</p>
     * <p>5、execution（* com.example.appdemo.controller..*.*（..））包及子包下所有的类的所有的方法</p>
     * <p>6、execution(* com.example.appdemo.controller..*.*(String,?,Long)) 包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法</p>
     * <p>7、execution(@annotation(com.example.appdemo.annotation.xx)) 使用xx注解的方法</p>
     */
    @Pointcut("execution(* com.example.appdemo.controller.*.*(..))")
    public void LogRecord(){
    }

    @Before("execution(* com.example.appdemo.controller.UserInfoController.getUserInfoAll(..))")
    public void beforeGet(){
        log.info("Before get ... ");
    }

    @After("@annotation(com.example.appdemo.annotation.SaveAnnotation)")
    public void afterSave(){
        log.info("After save ... ");
    }

    @Around("LogRecord()")
    public Object LogRecord(ProceedingJoinPoint pjp) throws Throwable{
        log.info("LogRecord around ... ");
        return pjp.proceed();
    }

}
