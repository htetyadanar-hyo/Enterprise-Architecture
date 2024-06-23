package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TraceRecord {

    @Id
    @GeneratedValue
    private long Id;

    private LocalDateTime createdDate;
    private String result;
    protected TraceRecord(){}
    public TraceRecord(String result){
        this.createdDate = LocalDateTime.now();
        this.result = result;
    }
}
