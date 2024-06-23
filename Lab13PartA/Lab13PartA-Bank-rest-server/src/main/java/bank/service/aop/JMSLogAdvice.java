package bank.service.aop;

import bank.integration.logging.LoggerImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {

    @Autowired
    private LoggerImpl logger;

    @After("execution(* bank.integration.jms.JMSSenderImpl.sendJMSMessage(..)) && args(text)")
    public void logJMSMessage(JoinPoint joinPoint, String text){
        logger.log("JMS message sent:" + text);
    }
}
