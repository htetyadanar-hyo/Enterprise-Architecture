package applicationProperty;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class myMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBootProjectApplication.class);
        EmailService emailService = context.getBean("emailServiceImpl", EmailServiceImpl.class);
        emailService.sendEmail();
    }
}
