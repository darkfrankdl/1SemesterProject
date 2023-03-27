package model;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description En container, som indeholder produkt objekter.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class ProductCon {
	private static ProductCon instance;
	private List<Product> products;
	
	private ProductCon() {
		products = new ArrayList<>();
	}
	
	/**
	 * @Description Finder og returnerer et produkt ud fra en stregkode.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Product findProductByBarcode(String barcode) {
		Product p = null;
		for (int i = 0; i < products.size() && p == null; i++) {
			if (products.get(i).getBarcode().equals(barcode)) {
				p = products.get(i);
			}
		}
		return p;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public static ProductCon getInstance() {
		if (instance == null) {
			instance = new ProductCon();
		}
		return instance;
	}
	
}
