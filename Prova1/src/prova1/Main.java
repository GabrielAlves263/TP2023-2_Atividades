package prova1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Configurações Gerais
		Scanner scan = new Scanner(System.in);
		Relatorio relatorio = new Relatorio();
		int opc;
		boolean sair = false;
		
		// Geração do sistema e dos planetas
		Sistema javaLar = new Sistema();
		javaLar.addPlaneta(new Python("Python"));
		javaLar.addPlaneta(new JavaScript("JavaScript"));
		javaLar.addPlaneta(new Ruby("Ruby"));
		javaLar.addPlaneta(new Php("PHP"));
		javaLar.addPlaneta(new CSharp("Csharp"));
		javaLar.addPlaneta(new Cpp("Cpp"));
		javaLar.addPlaneta(new C("C"));
		
		System.out.println("Ola, sejam bem-vindo ao Sistema JavaLar!");
		
		// Menu Principal
		while(!sair) {
			System.out.println("\nEscolha uma opcao: ");
			System.out.println("1 - Iniciar");
			System.out.println("2 - Sair");
			opc = scan.nextInt();
				
			// Iniciar
			if(opc == 1) {
				int tempo;
				int bugs;
				int devs;
				
				// Obtem as informações sobre a rodada
				System.out.print("\nUnidades de tempo: ");
				tempo = scan.nextInt();
				System.out.print("Quantidade de bugs: ");
				bugs = scan.nextInt();
				System.out.print("Quantidade de desenvolvedores: ");
				devs = scan.nextInt();
				
				javaLar.rodar(tempo);
				javaLar.addBugs(bugs);
				javaLar.addDevs(devs);
				javaLar.removerBugs(javaLar.detectarColisoesBugs());
				javaLar.removerDevs(javaLar.detectarColisoesDevs());
				javaLar.removerExplodidos(javaLar.detectarExplosoes());
				
			}
			// Sair
			else if(opc == 2) {
				scan.close();
				sair = true;				
			}
			// Opção inválida
			else {
				System.out.println("Opcao invalida!");				
			}
		}		

			// Imprime o Relatório final
			System.out.println("\n--- / Relatorio do Sistema / ---");
			relatorio.imprimirRelatorio(javaLar.getPlanetas());
			relatorio.imprimirRelatorio(javaLar.getExplodidos());
			
			System.out.println("Planetas que explodiram:");
			relatorio.imprimirExplodidos(javaLar.getExplodidos());
			
			relatorio.imprimirInstantes(javaLar);
			
			System.out.println("\nSaindo do Sistema JavaLar... volte sempre!");
	}

}
