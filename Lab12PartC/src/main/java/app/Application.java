package app;

import configuration.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import service.AppService;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@ComponentScan("service")
public class Application implements CommandLineRunner {
    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String...args) throws Exception{
        appService.print();
    }
}
