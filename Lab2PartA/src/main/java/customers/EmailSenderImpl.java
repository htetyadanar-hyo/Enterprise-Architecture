package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("emailSender")
public class EmailSenderImpl implements EmailSender {
	@Value("${outgoingMailServer}")
	String outgoingMailServer;

	//private Logger logger = new LoggerImpl();

	@Autowired
	private Logger logger;

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}

}
