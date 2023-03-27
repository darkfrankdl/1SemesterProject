package model;

/**
 * @Description Indeholder informationer om en kunde.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class Customer extends Person {
	private int customerID;
	private String customerType;
	
	public Customer(String name, String email, String phoneNo , String customerType) {
		super(name,email,phoneNo);
		this.customerType = customerType;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
