package cn.agree.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect // 表示当前是一个切面类
public class Logger {

    /*
    *  前置通知
    * */
    @Before("execution(* cn.agree.service.impl.AccountServiceImpl.saveAccount())")
    public void beforePrintLog() {
        System.out.println("前置通知:Logger类中的beforePrintLog方法开始记录日志...");
    }

    /**
     * 后置通知
     */
    @AfterReturning("execution(* cn.agree.service.impl.AccountServiceImpl.deleteAccount(..))")
    public void afterReturningPrintLog() {
        System.out.println("后置通知：Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("execution(* cn.agree.service.impl.AccountServiceImpl.updateAccount(..))")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }


    /**
     * 最终通知
     */
    // @After("execution(* cn.agree.service.impl.AccountServiceImpl.updateAccount(..))")
    // public void afterPrintLog() {
    //     System.out.println("最终通知：Logger类中的afterPrintLog方法开始记录日志了。。。");
    // }

    /*
    * 切入点表达式
    * */
   /* @Pointcut("execution(* cn.agree.service.impl.*.*(..))")
    private void pt1() {}*/


    /**
     * 环绕通知
     * @param pjp
     * @return
     */
   /* @Around("pt1()")//注意：千万别忘了写括号
    public void aroundPrintLog(ProceedingJoinPoint pjp) {
    }*/

}
