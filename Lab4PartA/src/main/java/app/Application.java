package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;


@SpringBootApplication
@ComponentScan(basePackages = {"app", "domain", "repository"})
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department itDept = new Department("IT");
		Department hRDept = new Department("HR");
		itDept.addEmployee(new Employee("John"));
		itDept.addEmployee(new Employee("Renee"));
		hRDept.addEmployee(new Employee("Suzi"));

		departmentRepository.save(itDept);
		departmentRepository.save(hRDept);

		System.out.println("No.(a)");
		Collection<Department> departments = departmentRepository.findAll();
		for(Department d: departments){
			System.out.println(d);
		}
		System.out.println("-------------------------\n");
		Publisher p1 = new Publisher("Publisher One");
		Publisher p2 =new Publisher("Publisher Three");
		publisherRepository.save(p1);
		publisherRepository.save(p2);

		Book b1 = new Book("BookOne","AuthorOne",p1);
		Book b2 = new Book("BookTwo","AuthorTwo",p2);
		Book b3 = new Book("BookThree","AuthorThree",p1);
		Book b4 = new Book("BookFour","AuthorFour",p2);

		bookRepository.save(b1);
		bookRepository.save(b2);
		bookRepository.save(b3);
		bookRepository.save(b4);

		System.out.println("No.(b)");
		Collection<Book> books = bookRepository.findAll();
		for(Book b: books){
			System.out.println(b);
		}
		System.out.println("-------------------------\n");

		Flight f1 = new Flight("111","Chicago","New York", LocalDate.now());
		Flight f2 = new Flight("222","New York","Chicago", LocalDate.now());
		Flight f3 = new Flight("333","Uk","US", LocalDate.now());
		flightRepository.save(f1);
		flightRepository.save(f2);
		flightRepository.save(f3);

		Passenger pa1 = new Passenger("JJ");
		Passenger pa2 = new Passenger("KK");
		Passenger pa3 = new Passenger("LL");
		pa1.addFlight(f1);
		pa1.addFlight(f2);
		pa2.addFlight(f2);
		pa3.addFlight(f3);

		passengerRepository.save(pa1);
		passengerRepository.save(pa2);
		passengerRepository.save(pa3);

		System.out.println("No.(c)");
		Collection<Passenger> passengers = passengerRepository.findAll();
		for(Passenger pa: passengers){
			System.out.println(pa);
		}
		System.out.println("-------------------------\n");

		Student s1 = new Student("John1","Wick1");
		Student s2 = new Student("John2","Wick2");
		Student s3 = new Student("John3","Wick3");
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);

		School sc1 = new School("MIU");
		sc1.addStudents(s1);
		sc1.addStudents(s2);
		sc1.addStudents(s3);
		schoolRepository.save(sc1);

		System.out.println("No.(d)");
		Collection<School> schools = schoolRepository.findAll();
		for(School sc: schools){
			System.out.println(sc);
		}
		System.out.println("-------------------------\n");

	}

}
