package OrderOfExecution;

public class AccountRepositoryImpl implements IAccountRepository{
    @Override
    public void createAccount() {
        System.out.println("Account created!");
    }
}
