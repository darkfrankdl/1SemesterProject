package model;

/**
 * @Description Indeholder informationer om et bestemt produkt og antallet af produkter,
 * som tilføjes til en ordre.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderLine {
	private int quantity;
	private double subtotal;
	private Item i;
	
	//Køres når et nyt produkt tilføjes til ordrelinjen.
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
	
	//Køres når et produkt, som allerede er i en ordrelinje på ordren, bliver tilføjet igen og dermed ikke skal oprettes som ny linje
	//men istedet ændre på mængden af den tidligere ordrelinje.
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
