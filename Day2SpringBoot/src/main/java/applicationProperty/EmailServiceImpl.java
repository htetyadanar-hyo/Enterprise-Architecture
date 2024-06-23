package applicationProperty;

import applicationProperty.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Value(" ${smtpserver}")
    String smtpServer;

    public void sendEmail(){
        System.out.println("Sending email ..."+ smtpServer);
    }
}
