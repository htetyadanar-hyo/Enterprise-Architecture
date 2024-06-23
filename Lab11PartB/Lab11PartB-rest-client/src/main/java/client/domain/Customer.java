package client.domain;

public class Customer {


	private int id;

	private String name;

	protected Customer(){}

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
