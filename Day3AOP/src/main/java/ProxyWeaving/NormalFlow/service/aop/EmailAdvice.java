package ProxyWeaving.NormalFlow.service.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
//When a class is annotated with @Component, it tells Spring to treat this class as a Spring bean and include it in the application context.
public class EmailAdvice {

    @AfterReturning("execution(* ProxyWeaving.NormalFlow.repository.AccountRepository.removeAccount(..))")
    public void sendEmailMessage(){
        System.out.println("Sending email after account removal");
    }
}
