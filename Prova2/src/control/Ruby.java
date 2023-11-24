package control;

import javax.swing.ImageIcon;

public class Ruby extends Planeta{
	
	public Ruby(String nome) {
		super(nome);
		this.id = 3;
		this.icon = new ImageIcon("imgs/rubyIcon.png");
		this.posX = 11;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 48f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 4;
		this.limiteMaxX = 11;
		this.limiteMaxY = 12;
		this.resumo = "Ruby foi originado de uma gigante pedra zodiacal que se formou em JavaLar.\n"
				+ "E o planeta mais brilhante do Sistema pelo fato de ser orbitado por pequenas costelacoes conhecidas como Gems.\n"
				+ "Seu territorio e composto por rails, um elemento derivado das Gems que formam o Ecossistema Ruby on Rails.";
		}
}
