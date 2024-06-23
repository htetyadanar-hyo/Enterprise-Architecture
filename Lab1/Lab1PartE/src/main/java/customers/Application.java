package customers;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
		public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			CustomerService customerService = context.getBean("customerService",CustomerService.class);
			customerService.addCustomer("Frank Brown", "fbrown@acme.com", "mainstreet 5", "Chicago", "60613");
			ProductService productService = context.getBean("productService",ProductService.class);
			productService.addNewProduct("Mac",1,3000,"apple@a.com");
		}
}

