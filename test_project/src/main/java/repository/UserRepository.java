package repository;

import domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
