package OrderOfExecution;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyApp {
    private PaymentService paymentService;

    /// Setter for dependency injection
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void init(){
        System.out.println("Init method called");
    }

    public void run(){
        System.out.println("Application is running");
        paymentService.savePayment();
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy method called");
    }
}
