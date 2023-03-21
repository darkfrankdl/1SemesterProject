package model;

/**
 * @Description En abstrakt superklasse, som indeholder informationer,
 * der anvendes af dens to subklasser.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public abstract class Item {
	private String name;
	private double price;
	private String location;
	private int stock;
	
	protected Item(String name, double price, String location, int stock) {
		this.name = name;
		this.price = price;
		this.location = location;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
