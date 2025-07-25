package entities;

public class ItemOrder {
	//atributos
	private Product product;
	private int quantity;
	
	public ItemOrder(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	//getters
	public double getSubtotal() {
		return product.getPrice() * quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return product.getName() + " X" + quantity + " = R$" + String.format("%.2f", getSubtotal());
	}
	
	
	
	
	
	
	
	
}
