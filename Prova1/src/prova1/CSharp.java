package prova1;

public class CSharp extends Planeta {
	
	public CSharp(String nome) {
		super(nome);
		this.posX = 13;
		this.posY = 8;
		this.velocidadeTranslacao = 1;
		this.velocidadeRotacao = 4f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 2;
		this.limiteMaxX = 13;
		this.limiteMaxY = 14;
	}
}
