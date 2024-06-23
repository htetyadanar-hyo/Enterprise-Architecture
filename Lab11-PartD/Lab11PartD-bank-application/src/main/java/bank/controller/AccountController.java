package bank.controller;


import bank.service.AccountServiceImpl;
import bank.service.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping
    public AccountDTO createAccount(@RequestParam long accountNumber, @RequestParam String customerName) {
        return accountService.createAccount(accountNumber, customerName);
    }

    @PostMapping("/{accountNumber}/deposit")
    public void deposit(@PathVariable long accountNumber, @RequestParam double amount) {
        accountService.deposit(accountNumber, amount);
    }

    @GetMapping("/{accountNumber}")
    public AccountDTO getAccount(@PathVariable long accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    @GetMapping
    public Collection<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/{accountNumber}/withdraw")
    public void withdraw(@PathVariable long accountNumber, @RequestParam double amount) {
        accountService.withdraw(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/depositEuros")
    public void depositEuros(@PathVariable long accountNumber, @RequestParam double amount) {
        accountService.depositEuros(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/withdrawEuros")
    public void withdrawEuros(@PathVariable long accountNumber, @RequestParam double amount) {
        accountService.withdrawEuros(accountNumber, amount);
    }

    @PostMapping("/{fromAccountNumber}/transfer")
    public void transferFunds(@PathVariable long fromAccountNumber, @RequestParam long toAccountNumber, @RequestParam double amount, @RequestParam String description) {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }
}
