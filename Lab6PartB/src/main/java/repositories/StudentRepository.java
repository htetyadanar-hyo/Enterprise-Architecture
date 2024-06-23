package repositories;

import domain.Course;
import domain.Department;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s join fetch s.department d where d.name = :name")
    List<Student> getAllByDepartment(@Param("name") String name);

    @Query("select s from Student s join fetch s.grades g join fetch g.course c where c.name = :name ")
    List<Student> getAllByGradesCourse(@Param("name") String name);
}
