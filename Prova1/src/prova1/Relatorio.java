package prova1;

import java.util.ArrayList;

public class Relatorio {
	
	public Relatorio(Sistema sistema) {
		System.out.println("\n--- / Relatorio do Sistema / ---");
		imprimirRelatorio(sistema.getPlanetas());
		imprimirRelatorio(sistema.getExplodidos());
		imprimirExplodidos(sistema.getExplodidos());
		imprimirInstantes(sistema);
	}
	
	public void imprimirRelatorio(ArrayList<Planeta> planetas) {

		for(Planeta planeta : planetas) {
			System.out.println("Planeta: " + planeta.getNome());
			System.out.print("Colidiu com " + planeta.colisoesBugs.size() + " bugs");
			System.out.println(" e " + planeta.colisoesDevs.size() + " devs");
			System.out.println("Velocidade de rotacao: " + planeta.getVelocidadeRotacao());
			System.out.println("Velocidade media de translacao: " + planeta.getVelocidadeMedia());
			System.out.println("Horas passadas: " + planeta.getHorasPassadas());
			System.out.println("Anos passados: " + planeta.getAnosPassados());
			System.out.println("Resumo: " + planeta.resumo);
			System.out.println();
		}
	}
	
	public void imprimirExplodidos(ArrayList<Planeta> explodidos) {
		System.out.println("Planetas que explodiram:");
		
		if(explodidos.isEmpty()) {
			System.out.println("Nenhum");
		}
		else {
			for(Planeta planeta : explodidos) {
				System.out.println(planeta.getNome());
			}
		}
	}
	
	public void imprimirInstantes(Sistema sistema) {
		System.out.println("\nNumero de instantes solicitados: " + sistema.getInstantes());
	}
}	
	
