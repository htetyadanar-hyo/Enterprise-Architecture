package DI.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    EmailService emailService;

    public void addCustomer(){
        emailService.sendEmail();
    }
}
