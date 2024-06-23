package DI.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private EmailService emailService;

    @Autowired
    public CustomerService(EmailService emailService){
        this.emailService = emailService;
    }

    public void addCustomer(){
        emailService.sendEmail();
    }
}
