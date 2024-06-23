package bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {

    Logger logger = LoggerFactory.getLogger(StopWatchAdvice.class);

    // All methods from the service class in the order package
    @Around("execution(* bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object = call.proceed();
        clock.stop();
        logger.info(clock.prettyPrint());
        return object;
    }
}

