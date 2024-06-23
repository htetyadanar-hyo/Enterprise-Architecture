package domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String grade;

    @ManyToOne
    private Course course;

    protected Grade(){}

    public Grade(String grade,Course course){
        this.grade = grade;
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
