package DI.Property;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProperty {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("propertyConfig.xml");
        AccountService accountService = context.getBean("accountService",AccountService.class);
        accountService.performService();
    }
}
