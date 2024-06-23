package ProxyWeaving.TargetClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("traceAdviceTarget")
public class TAdvice {
    @After("execution(* ProxyWeaving.TargetClass.Customer.setName(..))")
    public void tracemethod(JoinPoint joinpoint) {
        Customer customer = (Customer) joinpoint.getTarget();
        System.out.println("method = " + joinpoint.getSignature().getName());
        System.out.println("customer age = " + customer.getAge());
    }
}

