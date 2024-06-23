package bank.lazyInstantiation;

public class BankServiceImpl implements BankService{
    public BankServiceImpl(){
        System.out.println("Calling Constructor of BankServiceImpl");
    }

    public void addBank(String bankName){
        System.out.println("Calling addBank of BankServiceImpl");
    }
}
