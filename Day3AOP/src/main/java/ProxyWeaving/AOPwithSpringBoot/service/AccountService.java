package ProxyWeaving.AOPwithSpringBoot.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AccountService {
    Collection<String> accountList = new ArrayList<>();

    public void addAccount(String accountNumber){
        accountList.add(accountNumber);
        System.out.println("in execution of method addAccount");
    }
}
