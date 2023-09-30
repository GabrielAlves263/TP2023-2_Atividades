package prova1;

public class C extends Planeta{
	
	public C(String nome) {
		super(nome);
		this.posX = 15;
		this.posY = 8;
		this.velocidadeTranslacao = 10;
		this.velocidadeRotacao = 0.1f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 0;
		this.limiteMaxX = 15;
		this.limiteMaxY = 16;
	}
}
