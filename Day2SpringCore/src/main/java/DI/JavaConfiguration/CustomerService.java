package DI.JavaConfiguration;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService){
        this.emailService = emailService;
    }
    public void addCustomer(){
        emailService.sendEmail();
    }
}
