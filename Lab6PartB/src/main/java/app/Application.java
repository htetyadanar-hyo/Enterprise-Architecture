package app;

import domain.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;
import repositories.StudentRepository;


import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@Data
public class Application implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = new Department("IT");
		departmentRepository.save(department);


		Course course1 = new Course("EA");
		Course course2 = new Course("SE");
		courseRepository.save(course1);
		courseRepository.save(course2);

		Grade grade1 = new Grade("A",course1);
		Grade grade2 = new Grade("B",course2);
		gradeRepository.save(grade1);
		gradeRepository.save(grade2);

		Student s1 = new Student("JJ", "1111", department);
		s1.addGrade(grade1);
		s1.addGrade(grade2);
		studentRepository.save(s1);

		Student s2 = new Student("LL", "2222", department);
		s2.addGrade(grade1);
		studentRepository.save(s2);

		List<Student> studentsByDepartment = studentRepository.getAllByDepartment("IT");
		for(Student student: studentsByDepartment){
			System.out.println(student);
		}

		List<Student> studentsByCourseName = studentRepository.getAllByGradesCourse("EA");
		for (Student student: studentsByCourseName){
			System.out.println(student);
		}

	}

}
