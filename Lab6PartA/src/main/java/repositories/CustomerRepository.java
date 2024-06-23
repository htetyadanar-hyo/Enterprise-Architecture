package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllBy();

    List<Customer> findByUSA();

    @Query("select concat(c.firstName,' ',c.lastName) from Customer c where c.address.city = 'Amsterdam'")
    List<String> findFirstNameAndLastNameByAddressCity();
}
