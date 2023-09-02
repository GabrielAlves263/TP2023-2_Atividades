package Lista1;

public class Exerc12 {

	public static void main(String[] args) {
		int A = InputInt.input('A');
		int B = InputInt.input('B');
		
		if(A > 10) {
			System.out.println("A > 10");
		}
		else if(A + B == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("Numeros nao validos");
		}
		System.out.println("Sejam bem-vindos a disciplina Tecnicas de Progamacao");
	}
}
