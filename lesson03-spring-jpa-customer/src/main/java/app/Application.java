package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BookRepository;
import repository.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerRepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerRepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerRepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerRepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerRepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		//Create 3 books, and save them in the database
		bookRepository.save(new Book("Book One","11111","Author One",10.21));
		bookRepository.save(new Book("Book Two","22222","Author Two",9.99));
		bookRepository.save(new Book("Book Three","33333","Author Three",3.33));

		//Retrieve all books from the database and display them in the console
		System.out.println("Book Lists in the Database:");
		System.out.println("-------------------------------");
		for(Book book: bookRepository.findAll()){
			System.out.println(book);
		}
		System.out.println();

		//Update a book
		System.out.println("-------------------------------");
		Optional<Book> bookOpt = bookRepository.findById(2);
		if(bookOpt.isPresent()){
			Book book = bookOpt.get();
			book.setTitle("Updated Book Two");
			book.setAuthor("Updated Author Two");
			book.setPrice(11.20);
			bookRepository.save(book);
			System.out.println("Successfully Updated BookID:2");
		}
		System.out.println();


		//Delete a book
		System.out.println("-------------------------------");
		bookRepository.deleteById(1);
		System.out.println("Successfully deleted by BookID:1");
		System.out.println();

		//Retrieve all books from the database again and display them in
		System.out.println("-------------------------------");
		for(Book book: bookRepository.findAll()){
			System.out.println(book);
		}

	}

}
