package DI.Property;

public class AccountRepositoryImpl implements AccountRepository{
    @Override
    public void createAccount(){
        System.out.println("Account created!");
    }
}
