package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o.orderNumber from Order o where o.status= 'closed'")
    List<String> findAllByStatus();

    @Query("select o.orderNumber from Order o where o.customer.address.city = :city")
    List<String> findAllByOrderNumberByCustomerAddressCity(@Param("city") String city);
}
