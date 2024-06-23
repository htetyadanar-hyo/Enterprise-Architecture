package ProxyWeaving.TargetClass;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ProxyWeaving")
public class ApplicationTarget implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTarget.class, args);
    }

    @Override
    public void run(String... args) {
        Customer customer = new Customer();
        customer.setAge(25);
        customer.setName("John Doe"); // This will trigger the aspect
    }
}

