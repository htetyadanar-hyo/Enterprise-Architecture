package ProxyWeaving.AfterReturning;

import ProxyWeaving.AfterReturning.domain.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ProxyWeaving.AfterReturning")
public class ApplicationReturning implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationReturning.class, args);
    }

    @Override
    public void run(String... args) {
        Customer customer = new Customer();
        customer.setName("Htet");
        System.out.println("Customer Name: " + customer.getName());
    }
}

