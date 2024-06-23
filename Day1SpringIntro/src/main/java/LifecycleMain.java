import bank.lifeCycle.StatementService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleMain {

    public static void main(String[] args) {

        //init-method => Method called just after the constructor
        //destroy-method => Method called when you close the ApplicationContext
        System.out.println("\ninit-method and destroy-method....");
        System.out.println("1");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("lifeCycleConfig.xml");
        StatementService statementService = context.getBean("statementService", StatementService.class);
        System.out.println("2");
        statementService.addStatement("Hello");
        System.out.println("3");
        context.close();
    }
}
