package ProxyWeaving.Around.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ProfileAdvice{

    @Around("execution(* ProxyWeaving.Around.service.ProfileService.*(..))")
    public Object timerWatch(ProceedingJoinPoint call) throws Throwable{
        //Create and start a stopwatch
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        //Call the business logic method
        Object object = call.proceed();

        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }
}
