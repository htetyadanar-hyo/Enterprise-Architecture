package bank.service.aop;

import bank.integration.logging.LoggerImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOLogAdvice {
    @Autowired
    private LoggerImpl logger;

    @After("execution(* bank.repository.*.*(..))")
    public void logRepositoryCall(JoinPoint joinPoint){
        logger.log("method = " + joinPoint.getSignature().getName());
    }
}
