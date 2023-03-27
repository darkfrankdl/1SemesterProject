package model;

/**
 * @Description Indeholder informationer om produkter.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class Product extends Item{
	private String barcode;
	
	public Product(String name, double price, String location, int stock, String barcode) {
		super(name, price, location, stock);
		this.barcode = barcode;
	}

	public String getBarcode() {
		return barcode;
	} 
}
