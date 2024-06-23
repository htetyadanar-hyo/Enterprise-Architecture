package OrderOfExecution;

public class AccountServiceImpl implements IAccountService{
    private PaymentService paymentService;
    private IAccountRepository accountRepository;

    // Constructor for dependency injection
    public AccountServiceImpl(IAccountRepository accountRepository){
        this.accountRepository = accountRepository;
        System.out.println("Constructor for dependency injection");
    }

    // Setter for property injection
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @Override
    public void performService() {
        accountRepository.createAccount();
        paymentService.savePayment();
    }
}
