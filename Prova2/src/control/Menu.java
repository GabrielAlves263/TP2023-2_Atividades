package control;

import java.util.Scanner;

public class Menu {
	
	public Menu(Sistema sistema) {
		iniciarMenu(sistema);
	}
	
	private void iniciarMenu(Sistema sistema) {
		boolean sair = false;
		
		int opc;
		while(!sair) {
			mostrarOpcoes();
			opc = lerOpcao();
				
			// Iniciar
			if(opc == 1) {
				// Obtem as informações sobre a rodada
				int instantes = scanInstantes();;
				int bugs 	  = scanBugs();;
				int devs	  = scanDevs();				

				new Rodada(sistema, instantes, bugs, devs);
				
			}
			// Sair
			else if(opc == 2) {
				sair = true;
			}
			// Opção inválida
			else {
				System.out.println("Opcao invalida!");				
			}
		}
	}

	private int scanDevs() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Quantidade de desenvolvedores: ");
		return scan.nextInt();
	}

	private int scanBugs() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Quantidade de bugs: ");
		return scan.nextInt();
	}

	private int scanInstantes() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nUnidades de tempo: ");
		int instantes = scan.nextInt(); 			return instantes; 
	}

	private void mostrarOpcoes() {
		System.out.println("\nEscolha uma opcao: ");
		System.out.println("1 - Iniciar");
		System.out.println("2 - Sair");

	}
	
	private int lerOpcao() {
		Scanner scan = new Scanner(System.in);
		int opc;
		opc = scan.nextInt();
		return opc;
	}
}
