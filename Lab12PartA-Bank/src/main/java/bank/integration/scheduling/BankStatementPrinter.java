package bank.integration.scheduling;

import bank.service.AccountService;
import bank.service.dto.AccountDTO;
import bank.service.dto.AccountEntryDTO;
import bank.service.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BankStatementPrinter {

    Logger logger = LoggerFactory.getLogger(BankStatementPrinter.class);

    @Autowired
    private AccountService accountService;

    public BankStatementPrinter(AccountService accountService){
        this.accountService = accountService;
    }

    @Scheduled(fixedRate = 20000)
    public void printAccountStatements(){
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
