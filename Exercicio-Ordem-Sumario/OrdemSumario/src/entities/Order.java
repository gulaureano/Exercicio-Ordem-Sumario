package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	List<OrderItem> orderList = new ArrayList<>();
	SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		orderList.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderList.remove(item);
	}
	
	public double total() {
		Double total = 0.0;
		for (OrderItem list : orderList) {
			total = total + list.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdfOrder.format(getMoment()) + "\n");
		sb.append("Order Status: " + getStatus() + "\n");
		sb.append("Client: " + client.toString() + "\n");
		sb.append("Order Items: ");
		for(OrderItem list : orderList) {
			sb.append(list.toString() + "\n");
		}
		sb.append("Total Price: $");
		sb.append(total());
		return sb.toString();
	
	}
	
	
}
