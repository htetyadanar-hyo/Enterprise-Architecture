package bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {


    //All methods from the service class in the order package
    @Around("execution(* bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint call) throws Throwable{
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object = call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }
}
