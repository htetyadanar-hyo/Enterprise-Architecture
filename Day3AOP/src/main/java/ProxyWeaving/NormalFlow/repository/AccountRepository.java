package ProxyWeaving.NormalFlow.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    public void removeAccount(long accountNumber){
        System.out.println("Removing account with accountNumber: " + accountNumber);
    }
}
