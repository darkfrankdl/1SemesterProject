package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description En subklasse af Sale, som indeholder informationer om ordre.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class Order extends Sale {
	private Customer customer;
	private Employee employee;
	private LocalDate paidDate;
	private double total;
	private List<OrderLine> ols;
	
	public Order(Employee e) {
		super.setDate(LocalDate.now());
		this.employee = e;
		this.total = 0d;
		this.ols = new ArrayList<OrderLine>();
	}

	public Customer getCustomer() {
		return customer; 
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double subtotal) {
		this.total += subtotal;
	}

	public List<OrderLine> getOls() {
		return ols;
	}

	public void setOls(List<OrderLine> ols) {
		this.ols = ols;
	}
	
	// Tilf�jer en customer til ordren.
	public void addCustomer(Customer c) {
		if(c != null) {
			this.customer = c; 
		}
	}
	
	/**
	 * @Description Tilf�jer en ordrelinje plus et tilh�rende produkt til ordren.
	 * @param i den Item man �nsker at f�je til ordren.
	 * @param quantity den m�ngde af det Item man �nsker at tilf�je til ordren.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public boolean addOrderLine(Item i, int quantity) {
		OrderLine temp = findOLByItem(i);
		// Hvis et produkt allerede eksistere i en ordrelinje i forvejen k�res denne.
		if(temp != null && quantity > 0 && i.getStock() >= quantity) {
			temp.setQuantity(quantity);
			setTotal(i.getPrice() * quantity);
			return true;
		}
		else {
			// Betingelsen i nedenst�ende if(), s�rger for, at det ikke er muligt at k�be 0 eller f�rre produkter 
			// eller k�be flere produkter end der er p� lager.
			if(quantity > 0 && i != null && i.getStock() >= quantity) {
				OrderLine ol = new OrderLine(i,quantity);
				addOrderLine(ol);
				return true; 
			}
			else {
				return false;
			}
		}
	}
	
	// Tilf�jer en given ordrelinje (ol) til listen ols.
	private void addOrderLine(OrderLine ol) {
		this.ols.add(ol);
		setTotal(ol.getSubtotal());
	}
	
	/**
	 * @Description Finder og returnere den tilh�rende ordrelinje til et givet Item.
	 * @param i det Item man �nsker at tjekke om allerede eksisterer i en ordrelinje.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private OrderLine findOLByItem(Item i) {
		OrderLine res = null;	
		for(int j = 0; j < ols.size() && res  == null; j++) {
			if (ols.get(j).getItem() == i) {
				res = ols.get(j);
			}
		}
		return res;
	}
}
