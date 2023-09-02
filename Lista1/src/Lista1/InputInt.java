package Lista1;

import java.util.Scanner;

public class InputInt {
	public static int input(char n) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira o numero " + n + ":");
		return scan.nextInt();
		
	}
}
