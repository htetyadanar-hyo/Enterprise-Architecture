package DI.Property;

public class AccountService {
    private AccountRepository accountRepository;

    public void setAccountRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public void performService() {
        accountRepository.createAccount();
    }
}
