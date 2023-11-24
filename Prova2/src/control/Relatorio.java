package control;

import java.util.ArrayList;

public class Relatorio {
	
	// Construtor relatório da rodada
	public Relatorio(Sistema sistema, Rodada rodada) {
		System.out.println("\n--- / Relatorio da Rodada / ---");
		
		imprimirRelatorioRodada(sistema.getPlanetas());
		imprimirRelatorioBugs(sistema.getBugs());
		imprimirRelatorioDevs(sistema.getDevs());
 		imprimirPlanetasNorte(sistema);
 		imprimirPlanetasSul(sistema);
 		imprimirDistancia(sistema.getPlanetas());
 		imprimirDistanciaEuclidiana(sistema.getPlanetas());
 		imprimirAlinhamento(sistema);
	}
	
	// Construtor relatório final
	public Relatorio(Sistema sistema) {
		System.out.println("\n--- / Relatorio do Sistema / ---");
		imprimirRelatorioFinal(sistema.getPlanetas());
		imprimirRelatorioFinal(sistema.getExplodidos());
		imprimirExplodidos(sistema.getExplodidos());
		imprimirInstantes(sistema);
	}

 	private void imprimirRelatorioRodada(ArrayList<Planeta> planetas) {
 		
 		for(Planeta planeta : planetas) {
 			imprimirRelatorioPlaneta(planeta);
 			System.out.println();
 		}
 	}
	
	private void imprimirRelatorioFinal(ArrayList<Planeta> planetas) {

		for(Planeta planeta : planetas) {
			imprimirRelatorioPlaneta(planeta);
			System.out.print("Colidiu com " + planeta.colisoesBugs.size() + " bugs");
			System.out.println(" e " + planeta.colisoesDevs.size() + " devs");
			System.out.println("Velocidade de rotacao: " + planeta.getVelocidadeRotacao());
			System.out.println("Velocidade media de translacao: " + planeta.getVelocidadeMedia());
			System.out.println("Resumo: " + planeta.resumo);
			System.out.println();
		}
	}
	
	private void imprimirRelatorioPlaneta(Planeta planeta) {
			System.out.println("Planeta: " + planeta.getNome());
			System.out.println("Velocidade de Translacao: " + planeta.getVelocidadeTranslacao());
			System.out.println("Horas passadas: " + planeta.getHorasPassadas());
			System.out.println("Anos passados: " + planeta.getAnosPassados());
	}
	
	private void imprimirExplodidos(ArrayList<Planeta> explodidos) {
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
	
	private void imprimirInstantes(Sistema sistema) {
		System.out.println("\nNumero de instantes solicitados: " + sistema.getInstantes());
	}
	
	private void imprimirRelatorioBugs(ArrayList<Bug> bugs) {
		System.out.println("Total de Bugs: " + bugs.size());
		
		System.out.println("Posicoes dos Bugs:");
		for(Bug bug : bugs) {
			System.out.println("(" + bug.getPosX() + ", " + bug.getPosY() + ")");
		}
		System.out.println();
	}
	
	private void imprimirRelatorioDevs(ArrayList<Dev> devs) {
		System.out.println("Total de Devs: " + devs.size());
		
		System.out.println("Posicoes dos Devs:");
		for(Dev dev : devs) {
			System.out.println("(" + dev.getPosX() + ", " + dev.getPosY() + ")");
		}
		System.out.println();
	}
	
	private void imprimirPlanetasNorte(Sistema sistema) {
		System.out.println("Planetas no norte:");
		
		for(Planeta planeta : sistema.getPlanetasNorte()) {
			System.out.println(planeta.nome);
		}
		System.out.println();
	}
	
	private void imprimirPlanetasSul(Sistema sistema) {

		System.out.println("Planetas no Sul:");
		
		for(Planeta planeta : sistema.getPlanetasSul()) {
			System.out.println(planeta.nome);
		}
		System.out.println();
	}
	
	private void imprimirDistancia(ArrayList<Planeta> planetas) {
		System.out.println("Distancia entre os planetas:");
		
		for(int i = 0; i < planetas.size(); i++) {
			for(int j = i+1; j < planetas.size(); j++) {
				Planeta planetaI = planetas.get(i);
				Planeta planetaJ = planetas.get(j);
				int distancia = planetaI.getDistancia(planetaJ);
				System.out.println(planetaI.getNome() + " -> " + planetaJ.getNome() + " = " +distancia);
			}
		}
		System.out.println();
	}
	
	private void imprimirDistanciaEuclidiana(ArrayList<Planeta> planetas) {
		System.out.println("Distancia Euclidiana entre os planetas:");
		
		for(int i = 0; i < planetas.size(); i++) {
			for(int j = i+1; j < planetas.size(); j++) {
				Planeta planetaI = planetas.get(i);
				Planeta planetaJ = planetas.get(j);
				double distancia = planetaI.getDistanciaEuclidiana(planetaJ);
				System.out.print(planetaI.getNome() + " -> " + planetaJ.getNome() + " = ");
				System.out.printf("%.2f \n", distancia);
			}
		}
		System.out.println();
	}
	
	private void imprimirAlinhamento(Sistema sistema) {
		Detector detector = new Detector();
		
		if(detector.detectarAlinhamentos(sistema)) {
			System.out.println("Os planetas estao alinhados");
		}
	}
}	