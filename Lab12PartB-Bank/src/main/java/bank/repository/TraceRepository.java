package bank.repository;

import bank.event.AccountChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRepository extends JpaRepository<AccountChangeEvent, Long> {
}
