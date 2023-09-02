package Lista1;

public class Exerc06 {
	
	public static void main(String[] args) {
		int A = InputInt.input('A');
		int B = InputInt.input('B');
		
		if ( A > 10) {
			System.out.println("A > 10");
		}
		else {
			System.out.println("A <= 10");
		}
		
		if (A + B == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("A + B != 20");
		}
		
	}
}
