package ProxyWeaving.AfterReturning.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("traceAdviceReturning")
public class TraceAdvice {

    @AfterReturning(pointcut = "execution(* ProxyWeaving.AfterReturning.domain.Customer.getName(..))", returning = "retValue")
    public void traceMethod(JoinPoint joinPoint, String retValue) {
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("return value: " + retValue);
    }
}
