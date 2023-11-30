package control;

import javax.swing.ImageIcon;

public class Cpp extends Planeta {
	
	public Cpp(String nome) {
		super(nome);
		this.id = 6;
		this.icon = new ImageIcon("imgs/cppGIF.gif");
		this.posX = 14;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 0.5f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 1;
		this.limiteMaxX = 14;
		this.limiteMaxY = 15;
		this.resumo = "Cpp e habitado por seres que migraram do planeta C.\n"
				+ "Ele possui diversas industrias que criam e distribuem jogos.\n"
				+ "Suas principais cidades sao Boost e STL.";
	}
}
