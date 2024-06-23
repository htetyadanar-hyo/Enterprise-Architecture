import bank.prototype.PersonService;
import bank.singleton.AccountService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonPrototypeMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("singProtoConfig.xml");
        //Spring beans are default singletons. That's why output are the same
        System.out.println("\nDefault singletons....");
        AccountService accountService1 = context.getBean("accountService",AccountService.class);
        AccountService accountService2 = context.getBean("accountService",AccountService.class);
        System.out.println("AccountService1: " + accountService1);
        System.out.println("AccountService2: " + accountService2);

        //By adding scope="prototype", beans is not singletons. The output will be different.
        System.out.println("\nPrototype Beans....");
        PersonService personService1 = context.getBean("personService", PersonService.class);
        PersonService personService2 = context.getBean("personService", PersonService.class);
        System.out.println("PersonService1: " + personService1);
        System.out.println("PersonService2: " + personService2);


    }
}
