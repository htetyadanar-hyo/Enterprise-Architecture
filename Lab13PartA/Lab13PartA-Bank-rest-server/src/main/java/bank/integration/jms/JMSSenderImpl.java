package bank.integration.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("jmsSender")
public class JMSSenderImpl implements JMSSender {

	Logger logger = LoggerFactory.getLogger(JMSSenderImpl.class);

	@Override
	public void sendJMSMessage(String text) {
		logger.info("JMSSender: sending JMS message = {}", text);
	}
}

