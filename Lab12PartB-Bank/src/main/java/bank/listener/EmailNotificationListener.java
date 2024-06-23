package bank.listener;

import bank.event.AccountChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationListener {

    @EventListener
    public void onEvent(AccountChangeEvent event){
        System.out.println("Received Operation Event: " + event.getOperation());
        System.out.println("Received AccountNumber Event: " + event.getAccountNumber());
        System.out.println("Received Amount Event: " + event.getAmount());
        System.out.println("Received Date Event: " + event.getDate());
    }
}
