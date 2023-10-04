package prova1;

public class Rodada {
	
	public Rodada(Sistema sistema, int instantes, int bugs, int devs) {
		for (Planeta planeta : sistema.getPlanetas()) {
			planeta.transladar(instantes);
			planeta.rotacionar(instantes);
			planeta.attVelocidadeMedia();
		}
		sistema.addBugs(bugs);
		sistema.addDevs(devs);
		sistema.removerBugs(sistema.detectarColisoesBugs());
		sistema.removerDevs(sistema.detectarColisoesDevs());
		sistema.removerExplodidos(sistema.detectarExplosoes());
		sistema.inclementarInstantes(instantes);
	}
}
