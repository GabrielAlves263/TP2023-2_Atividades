package control;

import javax.swing.ImageIcon;

public class Php extends Planeta{
	
	public Php(String nome) {
		super(nome);
		this.id = 4;
		this.icon = new ImageIcon("imgs/phpIcon.png");
		this.posX = 12;
		this.posY = 8;
		this.posInicial[0] = posX;
		this.posInicial[1] = posY;
		this.velocidadeTranslacao = 2;
		this.velocidadeRotacao = 60f;
		this.velocidadeMedia = (float) velocidadeTranslacao;
		this.limiteMin = 3;
		this.limiteMaxX = 12;
		this.limiteMaxY = 13;
		this.resumo = "PHP foi um planeta que passou por 7 grandes eras conhecidas como versoes.\n"
				+ "Habitado por uma civilizacao evoluida da especie Phipers que trabalham com Tecnologias WEB.\n"
				+ "Possui uma capital chamada Lavarel, e 2 subCapitais Symfony e Codelgniter.";
	}
}
