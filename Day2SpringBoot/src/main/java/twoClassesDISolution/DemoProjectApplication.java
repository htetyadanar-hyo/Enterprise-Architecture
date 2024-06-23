package twoClassesDISolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {
    @Autowired
    private GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(greetingService.getTheGreeting());
    }
}

