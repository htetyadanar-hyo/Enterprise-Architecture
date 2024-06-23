package bank.eagerInstantiation;

public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl(){
        System.out.println("Calling Constructor of CustomerServiceImpl");
    }

    public void addCustomer(String customerName){
        System.out.println("Calling addCustomer of CustomerServiceImpl");
    }
}
