package model;
import java.time.LocalDate;

/**
 * @Description En abstrakt superklasse, som indeholder informationer,
 * der anvendes af dens subklasse, Order.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public abstract class Sale {
	private int ID;
	private LocalDate date;
	
	protected Sale() {
	
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
