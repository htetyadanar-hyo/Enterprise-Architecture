package domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class AuditData {
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private String createdBy;
    private String updatedBy;
}
