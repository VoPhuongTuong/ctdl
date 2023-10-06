package lab3;

public class OrderItem {
	private Product p;
	private int quality;
	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	public Product getProduct() {
		return p;
	}
public int getQuality() {
	return quality;
}
public double getSubtotal() {
	return p.getPrice()*quality;
}
}
