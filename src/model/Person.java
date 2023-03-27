package model;

/**
 * @Description En abstrakt superklasse, som indeholder informationer,
 * der anvendes af begge dens subklasser.
 * @Date 17/12/2021
 * @Version 1.0
 */
public abstract class  Person {
	private String name;
	private String email;
	private String phoneNo;
	
	protected Person (String name , String email , String phoneNo) {
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}