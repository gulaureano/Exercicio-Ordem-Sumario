package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfB = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: (dd/mm/yyyy)");
		Date birthdate = sdfB.parse(sc.nextLine());
		Client client = new Client(name, email, birthdate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		
		for (int i=1;i<=N;i++) {
			System.out.printf("Enter #%d item data: ", i);
			System.out.print("Product name: ");
			sc.nextLine();
			String nameP = sc.nextLine();
			System.out.print("Product price: ");
			Double priceP = sc.nextDouble();
			Product product = new Product(nameP, priceP);
			System.out.print("Quantity: ");
			Integer quantityP = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantityP, priceP, product);
			order.addItem(orderItem);
		}
			System.out.println("ORDER SUMMARY:");
			System.out.println(order.toString());
			
			
		
		
		
		sc.close();
	}

}
