package app;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxMessageListener {
    @JmsListener(destination = "taxQueue")
    public void receiveMessage(String message){
        System.out.println("Received message: " + message);
    }
}
