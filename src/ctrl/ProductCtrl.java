package ctrl;
import model.Product;
import model.ProductCon;

/**
 * @Description St�r for alt, som har med produkt at g�re.
 * @author Benjamin Andersen, Daniel Lundt, L�rke Imeland, Martin Uggerholm.
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
	 * @author Benjamin Andersen, Daniel Lundt, L�rke Imeland, Martin Uggerholm.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Product findProductByBarcode(String barcode) {
		return productCon.findProductByBarcode(barcode);
	}
}
