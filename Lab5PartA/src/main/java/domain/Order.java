package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "saleOrder")
public class Order {

	@Id
	@GeneratedValue
	private int orderId;

	private String orderNumber;

	private String date;

	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="customer_id")
	private Customer customer;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="o_id")
	private Collection<OrderLine> orderLines = new ArrayList<>();

	public Order() {
	}

	public Order(String orderNumber, String date, String status) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.status = status;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderLines() {
		return Collections.unmodifiableCollection(orderLines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderLines.add(ol);
	}

}
