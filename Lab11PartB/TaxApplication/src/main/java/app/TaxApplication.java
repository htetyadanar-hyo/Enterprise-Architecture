package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableJms
public class TaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxApplication.class,args);
    }
}
