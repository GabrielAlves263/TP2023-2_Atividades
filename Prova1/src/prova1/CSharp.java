package prova1;

public class CSharp extends Planeta {
	
	public CSharp(String nome) {
		super(nome);
		this.posX = 13;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 1;
		this.velocidadeRotacao = 4f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 2;
		this.limiteMaxX = 13;
		this.limiteMaxY = 14;
		this.resumo = "CSharp foi originado do planeta CPai que se dividiu em tres outros planetas.\n"
				+ "Governado pelo grupo Microsoft e predominado pelo ecossistema .NET.\n"
				+ "Seus habitantes, os Sharpers, se comunicam atraves de uma linguagem chamada CIL.";
	}
}
