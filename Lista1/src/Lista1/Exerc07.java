package Lista1;

public class Exerc07 {
	
	public static void main(String[] args) {
		int A = InputInt.input('A');
		int B = InputInt.input('B');
	
		if(A > 10) {
			if(A + B == 20) {
				System.out.println("numeros validos");
			}
		}
		else {
			System.out.println("numero nao valido");
		}
	}
}
