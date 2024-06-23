package bank.integration.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("TaxServiceJmsSender")
public class TaxServiceJmsSender implements JMSSender{
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendJMSMessage (String text){
        jmsTemplate.convertAndSend("taxService",text);
    }
}
