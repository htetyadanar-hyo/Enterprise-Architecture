package bank.lifeCycle;

public interface StatementService {
    public void addStatement(String statement);
    public void init();
    public void cleanup();

}
