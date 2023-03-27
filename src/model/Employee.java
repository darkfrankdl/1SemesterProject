package model;

/**
 * @Description Indeholder informationer om en medarbejder.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class Employee extends Person {
	private int employeeID;
	
	public Employee(String name, String email, String phoneNo){
		super(name, email, phoneNo);
		
		// "Hardcodes" til en bestemt v�rdi, da dette skal simulere at en employee allerede er logget ind.
		employeeID = 1;
	}

	public int getEmployeeID() {
		return employeeID;
	}
}
