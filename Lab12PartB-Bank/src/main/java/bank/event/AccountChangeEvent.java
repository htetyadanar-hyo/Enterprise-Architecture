package bank.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class AccountChangeEvent {

    @Id
    @GeneratedValue
    private Long id;
    private long accountNumber;
    private String operation;
    private double amount;
    private LocalDateTime date;

    public AccountChangeEvent(){}

    public AccountChangeEvent(long accountNumber,String operation,double amount){
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
