package prova1;

public class JavaScript extends Planeta {

	public JavaScript(String nome) {
		super(nome);
		this.posX = 10;
		this.posY = 8;
		this.velocidadeTranslacao = 3;
		this.velocidadeRotacao = 10f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 5;
		this.limiteMaxX = 10;
		this.limiteMaxY = 11;
	}
	
}
