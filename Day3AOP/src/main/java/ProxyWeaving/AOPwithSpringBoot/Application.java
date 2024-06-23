package ProxyWeaving.AOPwithSpringBoot;

import ProxyWeaving.AOPwithSpringBoot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    public void run(String...args){
        accountService.addAccount("23456");
    }
}
