package prova1;

public class Ruby extends Planeta{
	
	public Ruby(String nome) {
		super(nome);
		this.posX = 11;
		this.posY = 8;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 48f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 4;
		this.limiteMaxX = 11;
		this.limiteMaxY = 12;
		}
}
