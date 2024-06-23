package domain;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @MapKey(name="studentId")
    private Map<Integer, Student> students = new HashMap<>();


    protected School(){}
    public School(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        this.students.put(student.getStudentId(),student);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
