package repository;

import domain.Student;

import java.util.Collection;

public interface StudentRepository {
    void addStudent(Student student);
    void update(Student student);
    Student load(int studentNumber);
    void delete(Student student);
    Collection<Student> getAllStudents();
}
