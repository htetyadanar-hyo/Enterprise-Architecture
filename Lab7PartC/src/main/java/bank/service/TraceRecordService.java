package bank.service;

import bank.domain.TraceRecord;
import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TraceRecordService {
    @Autowired
    TraceRecordRepository traceRecordRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTraceRecord(String result){
        TraceRecord record = new TraceRecord(result);
        System.out.println(record);
        traceRecordRepository.save(record);
    }
}
