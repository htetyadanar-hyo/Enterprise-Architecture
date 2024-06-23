package client;

import client.dto.AccountDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private RestTemplate restTemplate = new RestTemplate();

	private String serverUrl = "http://localhost:8080/accounts";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// Create a new account
		AccountDTO accountDTO = restTemplate.postForObject(serverUrl + "?accountNumber={accountNumber}&customerName={customerName}",
				null, AccountDTO.class, 1001, "Alice");
		System.out.println("Created Account: " + accountDTO);

		// Deposit money into the account
		restTemplate.postForLocation(serverUrl + "/{accountNumber}/deposit?amount={amount}", null, 1001, 500.0);
		System.out.println("Deposited $500 into account number 1001");

		// Get account details
		accountDTO = restTemplate.getForObject(serverUrl + "/{accountNumber}", AccountDTO.class, 1001);
		System.out.println("Account Details: " + accountDTO);

		// Get all accounts
		AccountDTO[] accounts = restTemplate.getForObject(serverUrl, AccountDTO[].class);
		System.out.println("All Accounts: " + Arrays.asList(accounts));

		// Withdraw money from the account
		restTemplate.postForLocation(serverUrl + "/{accountNumber}/withdraw?amount={amount}", null, 1001, 200.0);
		System.out.println("Withdrew $200 from account number 1001");

		// Deposit Euros into the account
		restTemplate.postForLocation(serverUrl + "/{accountNumber}/depositEuros?amount={amount}", null, 1001, 100.0);
		System.out.println("Deposited 100 Euros into account number 1001");

		// Withdraw Euros from the account
		restTemplate.postForLocation(serverUrl + "/{accountNumber}/withdrawEuros?amount={amount}", null, 1001, 50.0);
		System.out.println("Withdrew 50 Euros from account number 1001");

		// Transfer funds to another account
		// Create another account for transferring funds
		AccountDTO anotherAccountDTO = restTemplate.postForObject(serverUrl + "?accountNumber={accountNumber}&customerName={customerName}",
				null, AccountDTO.class, 1002, "Bob");
		System.out.println("Created Another Account: " + anotherAccountDTO);

		// Transfer funds
		restTemplate.postForLocation(serverUrl + "/{fromAccountNumber}/transfer?toAccountNumber={toAccountNumber}&amount={amount}&description={description}",
				null, 1001, 1002, 300.0, "Payment for services");
		System.out.println("Transferred $300 from account number 1001 to account number 1002");

		// Verify accounts after transfer
		accountDTO = restTemplate.getForObject(serverUrl + "/{accountNumber}", AccountDTO.class, 1001);
		System.out.println("Account 1001 after transfer: " + accountDTO);

		anotherAccountDTO = restTemplate.getForObject(serverUrl + "/{accountNumber}", AccountDTO.class, 1002);
		System.out.println("Account 1002 after transfer: " + anotherAccountDTO);


	}

}
