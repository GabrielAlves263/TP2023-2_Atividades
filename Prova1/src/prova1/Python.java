package prova1;

public class Python extends Planeta {
		
	public Python(String nome) {
		super(nome);
		this.posX = 9;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 4;
		this.velocidadeRotacao = 24f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 6;
		this.limiteMaxX = 9;
		this.limiteMaxY = 10;
		this.resumo = "Python e o planeta mais proximo da estrela Java, por esse motivo, adquiriu caracteristicas semelhantes a ela.\n"
				+ "Seus habitantes sao cobras altamente inteligentes, cuja dieta consiste em devorar dados com voracidade.\n"
				+ "Essas serpentes deslizam por redes neurais absorvendo conhecimento e processando informacoes.";
	}
}
