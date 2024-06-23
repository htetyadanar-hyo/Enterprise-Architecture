package domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private String credits;

    @Column(name = "CourseDescription")
    private String description;

    @Column(name = "CourseCode")
    private String code;

    @Column(name = "CourseName")
    private String name;

    private String department;

    @OneToMany
    @JoinTable(name = "CoursePrerequisite",joinColumns = @JoinColumn(name = "CourseId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="PrerequisiteId",referencedColumnName = "id")
    )
    private Collection<Course> courserPrerequisites;

}
