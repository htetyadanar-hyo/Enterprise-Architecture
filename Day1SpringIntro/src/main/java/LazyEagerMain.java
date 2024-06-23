import bank.eagerInstantiation.CustomerService;
import bank.lazyInstantiation.BankService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyEagerMain {
    public static void main(String[] args) {
        System.out.println("Eagerly Instantiation....");
        System.out.println("1");
        //The CustomerService bean is eagerly instantiated
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("lazyEagerConfig.xml");
        System.out.println("2");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        System.out.println("3");
        customerService.addCustomer("Frank Brown");
        System.out.println("4");

        System.out.println("\nLazy Instantiation....");
        System.out.println("5");
        //The BankService bean is lazy instantiated
        BankService bankService = context.getBean("bankService", BankService.class);
        System.out.println("6");
        bankService.addBank("Bank of America");
        System.out.println("7");
    }
}
