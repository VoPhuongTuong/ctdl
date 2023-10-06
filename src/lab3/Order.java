package lab3;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getSubtotal();
		}
		return totalCost;
	}

	public boolean contains(Product p) {
		if (items == null || items.length == 0 || p == null) {
			return false;
		}
		return false;
	}

	public Product[] filter(String type) {
		return null;
	}
}
