package prova1;

public class Rodada {
	
	public Rodada(Sistema sistema, int instantes, int bugs, int devs) {
		
		rodarPlanetas(sistema, instantes);
		sistema.addBugs(bugs);
		sistema.addDevs(devs);
		
		detectarEventos(sistema);
		
		sistema.inclementarInstantes(instantes);
		
		new Relatorio(sistema, this);
	}

	public void detectarEventos(Sistema sistema) {
		Detector detector = new Detector();
		sistema.removerBugs(detector.detectarColisoesBugs(sistema));
		sistema.removerDevs(detector.detectarColisoesDevs(sistema));
		sistema.removerExplodidos(detector.detectarExplosoes(sistema));
	}

	public void rodarPlanetas(Sistema sistema, int instantes) {
		for (Planeta planeta : sistema.getPlanetas()) {
			planeta.transladar(instantes);
			planeta.rotacionar(instantes);
			planeta.attVelocidadeMedia();
		}
	}
	
}
