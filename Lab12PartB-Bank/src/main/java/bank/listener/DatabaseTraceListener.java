package bank.listener;

import bank.event.AccountChangeEvent;
import bank.repository.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTraceListener {
    @Autowired
    TraceRepository traceRepository;

    @EventListener
    public void onEvent(AccountChangeEvent accountChangeEvent){
        traceRepository.save(accountChangeEvent);
    }
}
