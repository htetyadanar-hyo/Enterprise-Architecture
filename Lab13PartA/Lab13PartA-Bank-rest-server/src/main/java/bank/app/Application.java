package bank.app;

import bank.service.AccountService;
import bank.service.dto.AccountDTO;
import bank.service.dto.AccountEntryDTO;
import bank.service.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collection;

@SpringBootApplication(scanBasePackages = {"bank"})
@EnableJpaRepositories("bank.repository")
@EntityScan("bank.domain")
public class Application implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");

		// use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdrawEuros(1263862, 230);

		// use account 2;
		accountService.deposit(4253892, 12450);
		accountService.depositEuros(4253892, 200);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");

		// show balances
		Collection<AccountDTO> accountlist = accountService.getAllAccounts();
		for (AccountDTO account : accountlist) {
			CustomerDTO customer = account.getCustomer();
			logger.info("Statement for Account: {}", account.getAccountNumber());
			logger.info("Account Holder: {}", customer.getName());
			logger.info("-Date-------------------------"
					+ "-Description------------------"
					+ "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntryList()) {
				logger.info("{}{}{}", String.format("%30s", entry.getDate().toString()),
						String.format("%30s", entry.getDescription()),
						String.format("%20.2f", entry.getAmount()));
			}
			logger.info("----------------------------------------"
					+ "----------------------------------------");
			logger.info("{}{}{}", String.format("%30s", ""),
					String.format("%30s", "Current Balance:"),
					String.format("%20.2f", account.getBalance()));
		}
	}
}
