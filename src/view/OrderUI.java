package view;
import ctrl.OrderCtrl;
import model.Order;
import model.OrderLine;

/**
 * @Description En TUI over Order Menuen.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class OrderUI {
	private TextInput textInput;
	private OrderCtrl orderCtrl;
	private Order o;
	
	public OrderUI() {
		this.textInput = new TextInput();
		this.orderCtrl = new OrderCtrl();
		orderMenu();
	}
	
	/**
	 * @Description Printer en brugervenlig hovedmenu.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public void printOrderMenu() {
		System.out.println("---Ordre Menu---");
		System.out.println("(1) Opret Ordre");
		System.out.println("(2) Find Ordre");
		System.out.println("(3) Afslut");
	}
	
	/**
	 * @Description S�rger for at brugerens input ift. hovedmenuen bliver registreret og skaber en �ndring i programmet.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public void orderMenu( ) {
		boolean finished = false;
		while(!finished) {
			printOrderMenu();
			int input = textInput.getNumberInput();
			
			switch(input) {
			case 1: 
				createOrder();
				break;
			case 2: 
				System.out.println("Denne mulighed er ikke implementeret.");
				break;
			case 3: 
				finished = true;				
				break;
			default: 
				System.out.println("Denne mulighed eksisterer ikke.");
				break;
			}
		}
	}

	/**
	 * @Description K�res ved input "1" fra hovedmenuen. S�rger for at 
	 * 				guide brugeren gennem ordre-oprettelses processen step for step. 
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private void createOrder() {
		//step 1
		o = orderCtrl.createOrder();
		printOrder();
		//step 2
		addCustomer();
		printOrder();
		//step 3
		addProducts(); 
		//step 4 - sker automatisk, n�r alle �nskede produkter er tilf�jet.
		endOrder();
	}
	
	/**
	 * @Description Step 3, st�r for at tilf�je produkter til ordren ud fra brugerens input.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private void addProducts() { 
		boolean finished = false;
		
		//S�rger for at flere produkter kan tilf�jes efter hinanden.
		while(!finished) {
			//s�ger stregkode for produkt...
			System.out.println("---Tilf�j produkt---");
			System.out.println("Indtast stregkode: ");
			System.out.println("For at afslutte - Tast \"Q\" ");
			String barcode = textInput.getInput();
			if(barcode.equalsIgnoreCase("Q")) break;
			
			//Bliver ved til brugeren har skrevet barcode for et eksisterende produkt.
			while(orderCtrl.getProductCtrl().findProductByBarcode(barcode) == null) {
				System.out.println("Dette produkt eksisterer ikke.");
				System.out.println("Indtast stregkode: ");
				barcode = textInput.getInput();
			}
			//s�ger antal af produkt...
			System.out.println("Indtast antal: ");
			int quantity = textInput.getNumberInput();
			if(!orderCtrl.addProduct(barcode, quantity)) {
				System.out.println("Dette antal produkter findes ikke.");
			}
			printOrder();
		}	
	}

	/**
	 * @Description Step 2, st�r for at tilf�je en customer til ordren ud fra brugerens input.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private void addCustomer() {
		//s�ger customer...
		System.out.println("---Tilf�j kunde---");
		System.out.println("Indtast kundeID: ");
		int id = textInput.getNumberInput();
		
		//Bliver ved til brugeren har skrevet et customer id for en eksisterende customer.
		while(orderCtrl.getCustomerCtrl().findCustomerByID(id) == null) {
			System.out.println("Denne kunde eksisterer ikke.");
			System.out.println("Indtast kundeID: ");
			id = textInput.getNumberInput();
		}
		orderCtrl.addCustomer(id);
	}

	/**
	 * @Description printOrder st�r for at printe en opdateret ordre i tui'en, 
	 * 				s�dan at brugeren kan f�lge med hvordan ordren udvikler sig i takt med at tingene tilf�jes.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private void printOrder() {
		System.out.println("---Ordre: "+ (o.getID() == 0 ? "" : o.getID()) +"---");
		System.out.println("Dato: " + o.getDate());
		System.out.println("Kunde: " + (o.getCustomer() == null ? "" : o.getCustomer().getName()));
		System.out.println("Produkter: ");

		for(OrderLine ol : o.getOls()) {
			System.out.println("\t" + ol.getItem().getName() + " x " + ol.getQuantity() + ", Subtotal: " + ol.getSubtotal());	
		}
		
		System.out.println("Medarbejder: " + o.getEmployee().getName());
		System.out.println("Total: " + o.getTotal());
	}
	
	/**
	 * @Description Step 4, afslutter ordren ved at l�gge den i sin container og printe den sidste status (kvitering)
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	private void endOrder() {
		if(orderCtrl.endOrder()) {
			printOrder();
		}
	}
}
