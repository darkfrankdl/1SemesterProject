package ctrl;
import model.Employee;

/**
 * @Description Indeholder den nuværende medarbejder som er logget ind.
 * 				Dette er en singleton.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class LoginCtrl {
	private static LoginCtrl instance;
	private Employee loggedIn;
	
	private LoginCtrl() {
		// Opretter en bestemt employee, da dette skal simulere at en employee allerede er logget ind.
		loggedIn = new Employee("John", "john1234@mail.dk", "20322300");
	}
	
	public static LoginCtrl getInstance() {
		if (instance == null) {
			instance = new LoginCtrl();
		}
		return instance;
	}
	
	public Employee getLoggedInEmployee() {
		return loggedIn;
	}
	
	public void setLoggedInEmployee(Employee employee) {
		this.loggedIn = employee;
	}
}
