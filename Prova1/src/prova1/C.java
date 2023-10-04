package prova1;

public class C extends Planeta{
	
	public C(String nome) {
		super(nome);
		this.posX = 15;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 10;
		this.velocidadeRotacao = 0.1f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 0;
		this.limiteMaxX = 15;
		this.limiteMaxY = 16;
		this.resumo = "C e o planeta ancestral de JavaLar e o berco da civilizao JavaLarense.\n"
				+ "Seus habitantes foram pioneiros da tecnologia codigo de baixo nivel.\n"
				+ "Sua populacao vive em pequenas comunidades que sobrevivem a partir da exploracao de tipos primitivos";
	}
}
