package OrderOfExecution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMainOrder {
    public static void main(String[] args) {
        // 1) Instantiate an instance of ApplicationContext
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("orderOfexecutionConfig.xml");
        IAccountService accountService = context.getBean("accountService",AccountServiceImpl.class);
        accountService.performService();
        MyApp myApp = context.getBean("myApp",MyApp.class);
        myApp.run();
        context.close();
    }
}
