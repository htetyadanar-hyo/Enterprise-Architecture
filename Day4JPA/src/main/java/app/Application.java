package app;

import domain.Person;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.PersonRepository;
import repository.StudentRepository;

import java.util.Collection;

@SpringBootApplication
@ComponentScan(basePackages = {"app", "domain", "repository"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "domain")
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.addStudent(new Student("Htet","h@h.com"));

		Collection<Student> students = studentRepository.getAllStudents();
		for(Student s: students){
			System.out.println(s);
		}

		personRepository.save(new Person("Ma Ma",23));
		Collection<Person> people = personRepository.findAll();
		for(Person p: people){
			System.out.println(p);
		}
	}
}
