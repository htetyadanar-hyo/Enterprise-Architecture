package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Student extends Person{

    private long StudentID;

    @Column(name = "Entry")
    private String entry;

    @Column(name = "AlternateID")
    private long alternateID;

    @Column(name = "ApplicantID")
    private long applicantID;

    @ManyToMany(mappedBy = "students")
    private List<CourseOffering> courseOfferings;
}
