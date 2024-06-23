package ProxyWeaving.NormalFlow.service.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    @Before("execution(* ProxyWeaving.NormalFlow.repository.AccountRepository.removeAccount(..))")
    public void logBefore(){
        System.out.println("Logging before removing account");
    }
}
