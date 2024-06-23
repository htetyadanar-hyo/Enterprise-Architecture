package domain;

import jakarta.persistence.*;

@Entity
public class LocationType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private String type;

    @Embedded
    private AuditData auditData;
}
