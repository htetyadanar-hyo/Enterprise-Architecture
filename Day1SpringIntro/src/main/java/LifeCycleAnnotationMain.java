import bank.lifeCycleAnnotation.DataService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleAnnotationMain {
    public static void main(String[] args) {
        System.out.println("1");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("lifeCycleAnnotationConfig.xml");
        System.out.println("2");
        DataService dataService = context.getBean("dataService",DataService.class);
        System.out.println("3");
        dataService.addData("Hello");
        System.out.println("4");
        context.close();
    }
}
