package ctrl;
import model.Product;
import model.ProductCon;

/**
 * @Description St�r for alt, som har med produkt at g�re.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class ProductCtrl {
	private ProductCon productCon;
	
	public ProductCtrl() {
		productCon = ProductCon.getInstance();
	}
	
	/**
	 * @Description Finder et produkt ud fra barcode.
	 * @param barcode String
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Product findProductByBarcode(String barcode) {
		return productCon.findProductByBarcode(barcode);
	}
}
