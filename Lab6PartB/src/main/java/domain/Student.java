package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String studentNumber;

    @ManyToOne
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Grade> grades = new ArrayList<>();

    protected Student(){}

    public Student(String name,String studentNumber,Department department){
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
