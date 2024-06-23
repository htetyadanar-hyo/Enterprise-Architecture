package bank.integration.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("TaxServiceJmsSender")
public class TaxServieJmsSender implements JMSSender{
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendJMSMessage (String text){
        System.out.println("send -------000000000000000000000---");
        System.out.println(text);
        jmsTemplate.convertAndSend("taxQueue",text);
    }
}
