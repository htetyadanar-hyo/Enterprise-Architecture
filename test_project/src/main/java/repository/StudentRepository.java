package repository;

import domain.Course;
import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select c from Student s join s.courseOfferings co join co.course c where s.id = :studentId")
    List<Course> findCoursesByStudentID(@Param("studentId") long studentId);
}
