package model;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description En container, som indeholder kunde objekter.
 * 				Dette er en singleton.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class CustomerCon {
	private int id;
	private static CustomerCon instance;
	private List<Customer> customers;
	private CustomerCon() {
		customers = new ArrayList<Customer>();
		id = 1;
	}
	
	public static CustomerCon getInstance() {
		if(instance == null) {
			instance = new CustomerCon();
		}
		return instance;
	}
	
	/**
	 * @Description Tilf�jer en kunde til listen over kunder.
	 * @param c Customer
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public void addCustomer(Customer c) {
		c.setCustomerID(id++);
		customers.add(c);	
	}
	
	/**
	 * @Description Finder en kunde ud fra customerID.
	 * @param customerID int
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public Customer findCustomerByID(int customerID) {
		Customer customer = null;
		boolean search = true;
		
		// f�r fat i containeren og ligger den midlertidigt lokalt.
		CustomerCon container = getInstance();
		
		for(int i  = 0; search && i<container.customers.size(); i++) {
			// finder containerens liste
			List<Customer> tempCustomers = container.customers;
			// f�r fat i customer objekter i listen 
			Customer tempCustomer = tempCustomers.get(i);
			// f�r fat i hver customer objekters id'er
			int id = tempCustomer.getCustomerID();
			// sammenligner 
			if(id==customerID) {
				customer= tempCustomer;
			}
		}
		return customer;
	}
}
