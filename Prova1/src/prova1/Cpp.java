package prova1;

public class Cpp extends Planeta {
	
	public Cpp(String nome) {
		super(nome);
		this.posX = 14;
		this.posY = 8;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 0.5f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 1;
		this.limiteMaxX = 14;
		this.limiteMaxY = 15;
	}
}
