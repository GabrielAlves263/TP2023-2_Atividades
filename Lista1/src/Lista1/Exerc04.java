package Lista1;

public class Exerc04 {
	
	public static void main(String[] args) {
		int A = InputInt.input('A');
		int B = InputInt.input('B');
		
		if( A > 10 || A + B == 20) {
			System.out.println("Numero valido");
		}
		else if( A == B) {
			System.out.println("A e igual a B;\nA e B sao diferentes de 10;\nA e menor que 10");
		}
		else {
			System.out.println("Numero nao valido");
		}
	}
}
