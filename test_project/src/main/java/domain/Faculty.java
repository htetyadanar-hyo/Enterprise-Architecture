package domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@SecondaryTable(name = "FacultyHobby",
        pkJoinColumns = @PrimaryKeyJoinColumn(name="Faculty_id"))
public class Faculty extends Person{

    @Column(name = "Salutation")
    private String salutation;

    @OneToMany
    @JoinColumn(name = "FacultyAdviserID")
    private Collection<Student> students;

    @Column(name = "FacultyHobby")
    @ElementCollection
    private Collection<String> hobbies;
}
