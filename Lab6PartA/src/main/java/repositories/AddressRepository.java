package repositories;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer > {

    @Query(value = "SELECT * FROM address WHERE CITY = 'Amsterdam'",nativeQuery = true)
    List<Address> findByCity();
}
