package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableKafka
public class Application implements CommandLineRunner {
    @Autowired
    Sender sender;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args)throws Exception{
        sender.createAccount(111111,"Dean");
        sender.deposit(111111,100);
        sender.withdraw(111111,50);
    }

}
