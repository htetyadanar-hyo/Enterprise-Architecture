package accounts.repository;

import accounts.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByAccountHolder_thenReturnAccount(){
        Account frank = new Account("111",123.00,"Frank");
        entityManager.persist(frank);
        entityManager.flush();

        Account foundByAccountHolder = accountRepository.findByAccountHolder(frank.getAccountHolder());
        Account foundByAccountNumber = accountRepository.findByAccountNumber(frank.getAccountNumber());
        Account foundByAmount = accountRepository.findByBalance(frank.getBalance());

        assertThat(foundByAccountHolder.getAccountHolder(), equalTo(frank.getAccountHolder()));
        assertThat(foundByAccountNumber.getAccountNumber(), equalTo(frank.getAccountNumber()));
        assertThat(foundByAmount.getBalance(), equalTo(frank.getBalance()));
    }
}
