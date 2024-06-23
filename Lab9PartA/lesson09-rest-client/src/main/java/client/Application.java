package client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private RestTemplate restTemplate = new RestTemplate();

	private String serverUrl = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// get frank
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1");
		System.out.println(book);

		// add Book2
		restTemplate.postForLocation(serverUrl, new Book("2","Jane2","HarryPotter2",102.23));

		// get Book2
		book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "2");
		System.out.println(book);

		// delete Book2
		restTemplate.delete(serverUrl+"/{isbn}", "2");

		// update Book1
		book.setAuthor("Kate");
		restTemplate.put(serverUrl+"/{isbn}" , book, "1");

		// get Book1
		book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1");
		System.out.println(book);

		// get all books
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println(books);
	}

}
