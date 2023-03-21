package test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ctrl.LoginCtrl;
import ctrl.OrderCtrl;
import model.Customer;
import model.CustomerCon;
import model.OrderCon;
import model.Product;
import model.ProductCon;

/**
 * @Description En JUnit test af use casen Create Order.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class JUnitTest {
	private static ProductCon productCon;
	private static CustomerCon customerCon;
	private static Product p1, p2, p3;
	private static Customer c1, c2;
	private static LoginCtrl loginCtrl;
	private static OrderCtrl orderCtrl;
	private static OrderCon orderCon;
	
	// Generere testdata...
	@BeforeAll
	public static void setupBefore() {
		productCon = ProductCon.getInstance();
		customerCon = CustomerCon.getInstance();
		// Repræsentere et login fra en bruger.
		loginCtrl = LoginCtrl.getInstance();
		orderCtrl = new OrderCtrl();
		orderCon = OrderCon.getInstance();
		
		p1 = new Product("Hammer", 100d, "DIY", 200, "1");
		p2 = new Product("Box of nails", 50d, "DIY", 500, "2");
		p3 = new Product("Wood plank 2x8", 20d, "Timber", 1000, "3");
		productCon.addProduct(p1);
		productCon.addProduct(p2);
		productCon.addProduct(p3);
		
		c1 = new Customer("Joe", "joe@joe.com", "11111111", "Private");
		c2 = new Customer("Jane", "jane@jane.com", "22222222", "Business");
		customerCon.addCustomer(c1);
		customerCon.addCustomer(c2);	
		
		orderCtrl.createOrder();
		
		
		
		
	}
	
	@BeforeEach
	public void setup() {
	}
	
	// Tester om den ønskede employee bliver føjet til ordren under oprettelsen af denne.
	@Test
	void loggedInEmployeeTest() {
		assertSame(loginCtrl.getLoggedInEmployee(), orderCtrl.getOrder().getEmployee());
		
	}
	
	// Tester om den ønskede customer bliver føjet til ordren korrekt.
	@Test
	void customerTest() {
		orderCtrl.addCustomer(1);
		assertSame(c1, orderCtrl.getOrder().getCustomer());
	}
	
	// Tester de forskellige grænseværdier omkring stock for et specifikt produkt, samt om det bliver tilføjet som forventet. 
	@Test
	void productTest() {
		assertFalse(orderCtrl.addProduct("1", -20));
		assertFalse(orderCtrl.addProduct("1", 300));
		assertFalse(orderCtrl.addProduct("1", 0));
		assertTrue(orderCtrl.addProduct("1", 20));
		assertTrue(orderCtrl.addProduct("1", 180));
	}
	
	
	
}
