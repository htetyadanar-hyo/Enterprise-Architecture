//Spring will automatically scan all classes in the package ‘applicationProperty’
//and all sub-packages of ‘applicationProperty’
package applicationProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        emailService.sendEmail();
    }
}
