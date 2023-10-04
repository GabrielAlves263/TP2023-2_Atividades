package prova1;

public class JavaScript extends Planeta {

	public JavaScript(String nome) {
		super(nome);
		this.posX = 10;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 3;
		this.velocidadeRotacao = 10f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 5;
		this.limiteMaxX = 10;
		this.limiteMaxY = 11;
		this.resumo = "JavaScript foi originado a partir de um fragmento desprendido da estrela Java.\n"
				+ "Possui duas luas chamadas HTML e CSS com as quais e interligado atraves de redes WEB.\n"
				+ "Seu territorio e dividio em ambientes chamados Frameworks e nao possui habitantes.";
	}
	
}
