package cn.agree.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// @Component("logger")
// @Aspect
public class LoggerAround {

    /*
    *  环绕通知
    *
    * */
    @Around("execution(* cn.agree.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("--------around-before------");
            result = joinPoint.proceed();
            System.out.println("--------around-after-------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }
}
