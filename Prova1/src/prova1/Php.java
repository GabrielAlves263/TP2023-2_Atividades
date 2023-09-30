package prova1;

public class Php extends Planeta{
	
	public Php(String nome) {
		super(nome);
		this.posX = 12;
		this.posY = 8;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 60f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 3;
		this.limiteMaxX = 12;
		this.limiteMaxY = 13;
	}
}
