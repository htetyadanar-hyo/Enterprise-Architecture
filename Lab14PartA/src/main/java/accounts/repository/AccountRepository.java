package accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
   Account findByAccountHolder(String accountHolder);

   Account findByAccountNumber(String accountNumber);

   Account findByBalance(double balance);

}
