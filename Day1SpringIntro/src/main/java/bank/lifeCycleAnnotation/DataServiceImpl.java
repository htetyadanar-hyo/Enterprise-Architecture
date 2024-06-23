package bank.lifeCycleAnnotation;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class DataServiceImpl implements DataService{
    public DataServiceImpl(){
        System.out.println("calling constructor of DataServiceImpl");
    }

    public void addData(String name){
        System.out.println("calling addCustomer of DataServiceImpl");
    }

    @PostConstruct
    public void init(){
        System.out.println("calling init method of DataService");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("calling cleanup method of DataService");
    }
}
