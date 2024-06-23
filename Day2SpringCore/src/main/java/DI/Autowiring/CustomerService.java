package DI.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    private EmailService emailService;

    @Autowired
    private PaymentService paymentService;

//    public CustomerService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    @Autowired
    public void setEmailService(EmailService emailService){
        this.emailService = emailService;
    }
    public void addCustomer(){
        emailService.sendEmail();
        paymentService.sentPayment();
    }
}
