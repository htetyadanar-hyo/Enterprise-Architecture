package SpringBootRunningOption;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootOptionOne {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBootOptionOne.class);
        CustomerService customerService = context.getBean("customerService",CustomerService.class);
        customerService.addCustomer();
    }
}
