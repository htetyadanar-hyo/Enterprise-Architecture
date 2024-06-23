package DI.Autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("autoWiringConfig.xml");
        CustomerService customerService = context.getBean("customerService",CustomerService.class);
        customerService.addCustomer();
    }
}
