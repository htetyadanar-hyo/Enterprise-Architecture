package DI.Constructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConstructor {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("constructorConfig.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.showPerformance();
    }
}
