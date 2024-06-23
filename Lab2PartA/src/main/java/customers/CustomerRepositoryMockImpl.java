package customers;

import customers.Customer;
import customers.CustomerRepository;
import customers.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
@Profile("test")
public class CustomerRepositoryMockImpl implements CustomerRepository {
    @Autowired
    private Logger logger;

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mock CustomerRepository: saving Mock customer "+customer.getName());
        logger.log("Mock Customer is saved in the DB: "+ customer.getName() );
    }
}
