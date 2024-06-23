package bank.service.dto;

import bank.domain.AccountEntry;

import java.util.Collection;

public class AccountDTO {
    private long accountNumber;

    private CustomerDTO customer;
    private Collection<AccountEntryDTO> entryList;
    private double balance;

    public AccountDTO(long accountNumber,CustomerDTO customer,Collection<AccountEntryDTO> entryList,double balance){
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.entryList = entryList;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public void addEntryList(AccountEntryDTO accountEntry) {
        entryList.add(accountEntry);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
