package ProxyWeaving.AOPwithSpringBoot.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TraceAdvice {

    @Before("execution(* ProxyWeaving.AOPwithSpringBoot.service.AccountService.*(..))")
    public void traceBeforeMethod(JoinPoint joinPoint){
        System.out.println("before execution of method " + joinPoint.getSignature().getName());
    }

    @After("execution(* ProxyWeaving.AOPwithSpringBoot.service.AccountService.*(..))")
    public void traceAfterMethod(JoinPoint joinPoint){
        System.out.println("after execution of method " + joinPoint.getSignature().getName());
    }

}
