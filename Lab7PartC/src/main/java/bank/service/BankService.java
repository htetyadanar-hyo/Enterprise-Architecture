package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.integration.EmailSender;
import bank.repository.AccountRepository;
import bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private TraceRecordService traceRecordService;
	

	@Transactional
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber){
		Account account = new Account(AccountNumber);
		Customer customer = new Customer(customerId, customerName);
        customer.setAccount(account);

		try{
			accountRepository.save(account);
			customerRepository.saveCustomer(customer);
			String result = "Customer" + customerName + "created with account" + AccountNumber;
			traceRecordService.saveTraceRecord(result);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
		}
		catch (Exception e){
			String result = "Could not create customer" + customerName + "with account" + AccountNumber;
			traceRecordService.saveTraceRecord(result);
			emailSender.sendEmail(emailAddress, "We could not create your account "+AccountNumber);
			throw e;
		}
	}



}
