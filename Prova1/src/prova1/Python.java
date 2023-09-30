package prova1;

public class Python extends Planeta {
		
	public Python(String nome) {
		super(nome);
		this.posX = 9;
		this.posY = 8;
		this.velocidadeTranslacao = 4;
		this.velocidadeRotacao = 24f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 6;
		this.limiteMaxX = 9;
		this.limiteMaxY = 10;
	}
}
