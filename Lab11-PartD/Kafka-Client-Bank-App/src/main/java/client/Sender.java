package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void createAccount(long accountNumber, String customerName){
        String message = accountNumber+","+customerName;
        kafkaTemplate.send("createAccount",message);
    }

    public void deposit(long accountNumber,double amount){
        String message = accountNumber+","+amount;
        kafkaTemplate.send("deposit",message);
    }

    public void withdraw(long accountNumber, double amount){
        String message = accountNumber+","+amount;
        kafkaTemplate.send("withdraw",message);
    }
}
