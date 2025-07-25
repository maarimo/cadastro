package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.ItemOrder;

public class Order {
	
	//atributos
	private int id;
	private LocalDate date;
	private Client client;
	private List<ItemOrder> items;
	
	public Order(int id, Client client) {
		this.id = id;
		this.client = client;
		this.date = LocalDate.now();
		this.items = new ArrayList<>();
	}

	//metodos
	public void addItem(ItemOrder item) {
		items.add(item);
	}
	
	public double getTotal() {
		double total = 0;
		for(ItemOrder item : items) {
			total += item.getSubtotal();
		}
		return total;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Client getClient() {
		return client;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pedido ID: ").append(id).append("\n");
		sb.append("Data: ").append(date).append("\n");
		sb.append("Cliente: ").append(client).append("\n");
		sb.append("Itens: \n");
		for(ItemOrder item : items) {
			sb.append("-").append(item.toString()).append("\n");
		}
		sb.append("Total: R$ ").append(String.format("%.2f", getTotal())).append("\n");
		return sb.toString();
	}
}
