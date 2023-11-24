package control;

import java.io.IOException;
import java.util.ArrayList;

public class Rodada {
	
	public Rodada(Sistema sistema, int instantes, int bugs, int devs) {
		
		rodarPlanetas(sistema, instantes);
		sistema.addBugs(bugs);
		sistema.addDevs(devs);
		
		detectarEventos(sistema);
		
		sistema.inclementarInstantes(instantes);
		
		new Relatorio(sistema, this);
	}
	
	public Rodada(Sistema sistema) {
		
		ArrayList<Planeta> planetas = sistema.getPlanetas();
		Arquivo arquivo = sistema.getArquivo();
		
		if(arquivo.naoFinalizou()) {
			String[] dados = arquivo.getDados();

			// Adiciona Bugs e Devs
			sistema.addBugs(Integer.parseInt(dados[8]));
			sistema.addDevs(Integer.parseInt(dados[9]));

			// Roda os planetas
			for(Planeta planeta : planetas) {
				rodarPlaneta(planeta, Integer.parseInt(dados[planeta.getId()]));
			}

			detectarEventos(sistema);
		}
	}

	public void detectarEventos(Sistema sistema) {
		Detector detector = new Detector();
		sistema.removerBugs(detector.detectarColisoesBugs(sistema));
		sistema.removerDevs(detector.detectarColisoesDevs(sistema));
		sistema.removerExplodidos(detector.detectarExplosoes(sistema));
	}

	public void rodarPlanetas(Sistema sistema, int instantes) {
		for (Planeta planeta : sistema.getPlanetas()) {
			rodarPlaneta(planeta, instantes);
		}
	}
	
	public void rodarPlaneta(Planeta planeta, int instantes) {
		planeta.transladar(instantes);
		planeta.rotacionar(instantes);
		planeta.attVelocidadeMedia();
	}
}
