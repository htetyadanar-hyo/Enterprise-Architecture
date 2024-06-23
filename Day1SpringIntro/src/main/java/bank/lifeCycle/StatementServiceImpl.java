package bank.lifeCycle;

public class StatementServiceImpl implements StatementService{
    public StatementServiceImpl(){
        System.out.println("calling constructor of StatementServiceImpl");
    }
    public void addStatement(String statement) {
        System.out.println("calling addStatement of StatementServiceImpl");
    }

    public void init(){
        System.out.println("calling init method of StatementService");
    }

    public void cleanup(){
        System.out.println("calling cleanup method of StatementService");
    }
}
