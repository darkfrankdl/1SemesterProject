package ctrl;
import model.Customer;
import model.CustomerCon;

/**
 * @Description Styrer alt der sker med kunder.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class CustomerCtrl {
	private CustomerCon customerCon;
	
	public CustomerCtrl() {
		customerCon = CustomerCon.getInstance();
	}
	
	/**
	 * @Description Finder en kunde ud fra customerID
	 * @param customerID int
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Customer findCustomerByID(int customerID) {
		Customer customer = null;
		
		customer = customerCon.findCustomerByID(customerID);
		
		return customer; 
	}
}
