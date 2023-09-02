package Lista1;

public class Exerc05 {

	public static void main(String[] args) {
		int A = InputInt.input('A');
		int B = InputInt.input('B');
		
		if( A > 10 || A + B == 20) {
			System.out.println("Numero valido");
		}
		else {
			System.out.println("Numero nao valido");
		}
	}
}
