package domain;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CDRepository;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int productNumber;

	private String name;

	private String description;

	private double price;

	public Product() {
	}

	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
