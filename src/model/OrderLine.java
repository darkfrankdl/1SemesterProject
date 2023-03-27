package model;

/**
 * @Description Indeholder informationer om et bestemt produkt og antallet af produkter,
 * som tilf�jes til en ordre.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderLine {
	private int quantity;
	private double subtotal;
	private Item i;
	
	//K�res n�r et nyt produkt tilf�jes til ordrelinjen.
	public OrderLine(Item i, int quantity) {
		this.i = i;
		this.quantity = quantity;
		//Forbedre. Tjek om quantity er ledig i stock.
		setSubTotal();
		setStock(quantity);
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public Item getItem() {
		return i;
	}
	
	//K�res n�r et produkt, som allerede er i en ordrelinje p� ordren, bliver tilf�jet igen og dermed ikke skal oprettes som ny linje
	//men istedet �ndre p� m�ngden af den tidligere ordrelinje.
	public void setQuantity(int q) {
		quantity += q;
		setSubTotal();
		setStock(q);
	}
	
	private void setSubTotal() {
		subtotal = i.getPrice() * quantity;
	}
	
	private void setStock(int quantity) {
		i.setStock(i.getStock()-quantity);
	}
}
