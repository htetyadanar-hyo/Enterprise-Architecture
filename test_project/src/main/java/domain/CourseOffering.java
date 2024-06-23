package domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class CourseOffering {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private String capacity;
    private String credits;

    @Enumerated(EnumType.STRING)
    private CourseOfferingType courseOfferingType;

    @Column(name = "Room")
    private String room;

    @Embedded
    private AuditData auditData;

    @ManyToMany
    @OrderColumn(name = "sequence")
    @JoinTable(name = "CourseRegistration",joinColumns = @JoinColumn(name = "StudentId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="CourseOfferingId",referencedColumnName = "id"))
    private Collection<Student> student;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "FacultyID")
    private Faculty faculty;

}
