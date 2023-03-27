package view;
import ctrl.LoginCtrl;
import model.Customer;
import model.CustomerCon;
import model.Product;
import model.ProductCon;

/**
 * @Description Generering af testdate til systemet.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class GenerateTestData {
	
	public GenerateTestData() { 
		ProductCon productCon = ProductCon.getInstance();
		CustomerCon customerCon = CustomerCon.getInstance();
		
		// Repr�sentere et login fra en bruger.
		LoginCtrl.getInstance();
		
		Product product1 = new Product("Hammer", 100d, "DIY", 200, "1");
		Product product2 = new Product("Box of nails", 50d, "DIY", 500, "2");
		Product product3 = new Product("Wood plank 2x8", 20d, "Timber", 1000, "3");
		productCon.addProduct(product1);
		productCon.addProduct(product2);
		productCon.addProduct(product3);
		
		Customer customer1 = new Customer("Joe", "joe@joe.com", "11111111", "Private");
		Customer customer2 = new Customer("Jane", "jane@jane.com", "22222222", "Business");
		customerCon.addCustomer(customer1);
		customerCon.addCustomer(customer2);		
	}
}
