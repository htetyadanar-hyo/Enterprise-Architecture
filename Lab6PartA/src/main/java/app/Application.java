package app;

import domain.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.AddressRepository;
import repositories.CDRepository;
import repositories.CustomerRepository;
import repositories.OrderRepository;


import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@Data
public class Application implements CommandLineRunner{

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CDRepository cdRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Product product = new Product();
//		product.setName("Hibernate 3");
//		product.setDescription("Good book on Hibernate");
//		product.setPrice(35.50);
		Product product1 = new Book("Hibernate 3","Good book on Hibernate",35.50,"1111");
		OrderLine ol1 = new OrderLine(2, product1);

//		Product product2 = new Product();
//		product2.setName("The best of Queen");
//		product2.setDescription("Album from 1995");
//		product2.setPrice(12.98);
		Product product2 = new CD("The best of Queen","Album from 1995",12.98,"U2");
		OrderLine ol2 = new OrderLine(4, product2);

		Product product3 = new DVD("The best of Queen2","Album from 1994",20.51,"Classic");
		OrderLine ol3 = new OrderLine(5,product3);

		Product product4 = new CD("The best of Queen","Album from 1995",9.0,"U2");
		OrderLine ol4 = new OrderLine(2,product4);

		Order o1 = new Order("234743", "12/10/06", "closed");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);
		o1.addOrderLine(ol4);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"Amsterdam", "43221", "USA");
		c1.addOrder(o1);
		o1.setCustomer(c1);

		orderRepository.save(o1);
		printOrder(o1);

		List<Customer> allCustomers = customerRepository.findAllBy();
		for(Customer c: allCustomers){
			System.out.println(c);
		}

		List<CD> allCDsWithU2LessThan10 = cdRepository.findByArtistAndPriceLessThan("U2",10);
		for(CD c: allCDsWithU2LessThan10){
			System.out.println(c);
		}

		List<Customer> allCustomersFromUSA = customerRepository.findByUSA();
		for(Customer c: allCustomersFromUSA){
			System.out.println(c);
		}

		List<CD> allCDsByArtist = cdRepository.findByArtist("U2");
		for(CD c: allCDsByArtist){
			System.out.println(c);
		}

		List<String> allOrdersByStatus = orderRepository.findAllByStatus();
		for(String o: allOrdersByStatus){
			System.out.println(o);
		}

		List<String> firstAndLastNameOfCustomersLiveInAmsterdam = customerRepository.findFirstNameAndLastNameByAddressCity();
		for(String c: firstAndLastNameOfCustomersLiveInAmsterdam){
			System.out.println(c);
		}

		List<String> allOrderNumbersByCity = orderRepository.findAllByOrderNumberByCustomerAddressCity("Amsterdam");
		for(String c: allOrderNumbersByCity){
			System.out.println(c);
		}

		List<CD> allCDsByArtistAndGreateThanPrice = cdRepository.findByArtistAndPriceGreaterThan("U2",8.2);
		for(CD c: allCDsByArtistAndGreateThanPrice){
			System.out.println(c);
		}

		List<Address> allAddressesByCity = addressRepository.findByCity();
		for(Address c: allAddressesByCity){
			System.out.println(c);
		}

		List<CD> allCDsByU2 = cdRepository.findByU2();
		for(CD c: allCDsByU2){
			System.out.println(c);
		}
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrderNumber());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstName() + " "
				+ cust.getLastName());
		for (OrderLine orderline : order.getOrderLines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.toString());
		}
	}
}
