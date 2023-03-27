package view;
import java.util.Scanner;

/**
 * @Description St�r for at registrerer brugerens input.
 * @Date 17/12/2021
 * @Version 1.0
 */
public class TextInput {
	private Scanner scanner;
	
	public TextInput() {
		scanner = new Scanner(System.in);
	}
	
	public String getInput() {
		return scanner.nextLine();
	}
	
	/**
	 * @Description St�r for at konvertere brugerens input fra String til Integer. 
	 * 				Taster brugeren forkerte input, k�rer metoden iterativt indtil et validt input kan returneres.
	 * @Date 17/12/2021
	 * @Version 1.0
	 */
	public int getNumberInput() {
		int temp = 0;
		try {
			temp = Integer.parseInt(scanner.nextLine());
			
		} catch(NumberFormatException e) {
			System.out.println("Indtast et positivt heltal!");
			temp = getNumberInput();
		}
		return temp;
	}
}
