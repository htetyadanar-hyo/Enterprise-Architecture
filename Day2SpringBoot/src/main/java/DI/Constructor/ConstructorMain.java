package DI.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConstructorMain implements CommandLineRunner {
    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(ConstructorMain.class,args);
    }

    @Override
    public void run(String...args){
        customerService.addCustomer();
    }
}
