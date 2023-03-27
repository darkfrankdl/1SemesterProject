package ctrl;
import java.time.LocalDate;

import model.Order;
import model.OrderCon;

/**
 * @Description St�r for alt, som har med ordre at g�re.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderCtrl {
	private ProductCtrl productCtrl;
	private CustomerCtrl customerCtrl;
	private LoginCtrl loginCtrl;
	private OrderCon orderCon;
	private Order order;
	
	public OrderCtrl() {
		this.productCtrl = new ProductCtrl();
		this.customerCtrl = new CustomerCtrl();
		this.loginCtrl = LoginCtrl.getInstance();
		this.orderCon = OrderCon.getInstance();
	}
	
	/**
	 * @Description Opretter en ordre, hvor en medarbejder tilknyttes.
	 * 				Herefter returneres ordren.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Order createOrder() {
		return order = new Order(loginCtrl.getLoggedInEmployee());
	}
	
	public void setLoginCtrl(LoginCtrl lCtrl) {
		this.loginCtrl = lCtrl;
	} 
	
	/**
	 * @Description Laver et metodekald p� ordren, som tilf�jer en kunde ud fra customerID,
	 * 				s� l�nge den findes i containeren.
	 * @param customerID int
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public void addCustomer(int customerID) {
		order.addCustomer(customerCtrl.findCustomerByID(customerID));
	}
	
	/**
	 * @Description Laver et metodekald p� ordren, som tilf�jer en OrderLine ud fra det produkt,
	 * 				og kvantiteten, som tilf�jes i parameterne.
	 * @param barcode String, quantity int
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public boolean addProduct(String barcode, int quantity) {
		return order.addOrderLine(productCtrl.findProductByBarcode(barcode),quantity);
	}
	
	/**
	 * @Description Afslutter ordren, og putter den i containeren.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public boolean endOrder() {
		order.setPaidDate(LocalDate.now());
		return orderCon.addOrder(order);
	}

	public Order getOrder() {
		return order;
	}

	public ProductCtrl getProductCtrl() {
		return productCtrl;
	}
	
	public CustomerCtrl getCustomerCtrl() {
		return customerCtrl;
	}
}
