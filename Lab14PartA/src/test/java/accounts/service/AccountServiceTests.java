package accounts.service;

import accounts.domain.Account;
import accounts.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration{
        @Bean
        public AccountService accountService(){
            return new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp(){
        String accountNumber = "1111";
        Account frank = new Account(accountNumber,123.1,"frank");

        Mockito.when(accountRepository.findById(accountNumber))
                .thenReturn(Optional.of(frank));

    }

    @Test
    public void whenValidAccountNumberThenAccountResponseShouldBeFound(){
        String accountNumber = "1111";
        AccountResponse found = accountService.getAccount(accountNumber);

        assertThat(found.getAccountNumber(),equalTo(accountNumber));
    }

    @Test
    public void checkCreatingAccount(){
       accountService.createAccount("111",12.21,"frank");
       verify(accountRepository).save(any(Account.class));

    }
}
