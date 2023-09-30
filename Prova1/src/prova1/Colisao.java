package prova1;

public class Colisao {
	
	// Colisão acontece entre um planeta e um Bug ou Dev
	private Planeta planeta;
	private Astro colisor;
	
	// Construtores
	public Colisao(Planeta planeta, Bug bug) {
		this.planeta = planeta;
		this.colisor = bug;
	}
	
	public Colisao(Planeta planeta, Dev dev) {
		this.planeta = planeta;
		this.colisor = dev;
	}
}
