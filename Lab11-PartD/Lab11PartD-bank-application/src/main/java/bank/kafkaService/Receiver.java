package bank.kafkaService;

import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    private AccountService accountService;

    @KafkaListener(topics={"createAccount"})
    public void createAccount(@Payload String message){
        String[] temp = message.split(",");
        long accountNumber = Long.parseLong(temp[0]);
        String customerName = temp[1];

        accountService.createAccount(accountNumber,customerName);
    }

    @KafkaListener(topics={"deposit"})
    public void deposit(@Payload String message){
        String[] temp = message.split(",");
        long accountNumber = Long.parseLong(temp[0]);
        double amount = Double.parseDouble(temp[1]);

        accountService.deposit(accountNumber,amount);
    }

    @KafkaListener(topics={"withdraw"})
    public void withdraw(@Payload String message){
        String[] temp = message.split(",");
        long accountNumber = Long.parseLong(temp[0]);
        double amount = Double.parseDouble(temp[1]);

        accountService.withdraw(accountNumber,amount);
    }

}
