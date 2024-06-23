package repository;

import domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student load(int studentNumber) {
        return entityManager.find(Student.class, studentNumber);
    }

    @Override
    public void delete(Student student) {
        if (entityManager.contains(student)) {
            entityManager.remove(student);
        } else {
            entityManager.remove(entityManager.merge(student));
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
