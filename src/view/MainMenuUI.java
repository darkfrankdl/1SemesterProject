package view;

/**
 * @Description Indeholder main af systemet.
 * @author Benjamin Andersen, Daniel Lundt, Lærke Imeland, Martin Uggerholm.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class MainMenuUI {
	public static void main(String[] args) {
		
		// Generere testdata, så programmet kan afprøves.
		GenerateTestData gtd = new GenerateTestData();
		
		// Repræsentere valget af "Lav ny ordre" i hovedmenuen.
		OrderUI oui = new OrderUI();
	}
}
