package DI.Constructor;

public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private PaymentService paymentService;
    public AccountServiceImpl(AccountRepository accountRepository,PaymentService paymentService){
        this.accountRepository = accountRepository;
        this.paymentService = paymentService;
    }
    @Override
    public void showPerformance(){
        accountRepository.print();
        paymentService.printPayment();
    }
}
