package domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "PersonAccount",
                pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    private String firstName;
    private String lastName;
    @Embedded
    private AuditData auditData;

    @Column(table = "PersonAccount")
    private String username;

    @Column(table = "PersonAccount")
    private String password;

}
