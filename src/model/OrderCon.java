package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description En container, som indeholder ordre objekter.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderCon {
	private static OrderCon instance;
	private List<Order> orders;
	private int id;
	
	private OrderCon() {
		orders = new ArrayList<Order>();
		id = 1;
	}
	
	public static OrderCon getInstance() {
		if(instance == null) {
			instance = new OrderCon();
		}
		return instance;
	}

	public List<Order> getOrders() {
		return new ArrayList<Order>(orders);
	}
	
	//giver ordren et ordrenummer n�r den tilf�jes til containeren/orders listen.
	public boolean addOrder(Order o) {
		o.setID(id++);
		return this.orders.add(o);
	}
}