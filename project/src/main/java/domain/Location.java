package domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capacity")
    private String capacity;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private LocationType locationType;

    @Embedded
    private AuditData auditData;
}
