package prova1;

import java.util.ArrayList;

public class Relatorio {
	
	public void imprimirRelatorio(ArrayList<Planeta> planetas) {
		
		for(Planeta planeta : planetas) {
			System.out.println("Planeta: " + planeta.getNome());
			System.out.print("Colidiu com " + planeta.colisoesBugs.size() + " bugs");
			System.out.println(" e " + planeta.colisoesDevs.size() + " devs");
			System.out.println("Velocidade de rotacao: " + planeta.getVelocidadeRotacao());
			System.out.println("Velocidade media de translacao: " + planeta.getVelocidadeMedia());
			System.out.println("Horas passadas: " + planeta.getHorasPassadas());
			System.out.println("Anos passados: ");
			System.out.println("Resumo: ");
			System.out.println();
		}
	}
	
	public void imprimirExplodidos(ArrayList<Planeta> explodidos) {
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
	
