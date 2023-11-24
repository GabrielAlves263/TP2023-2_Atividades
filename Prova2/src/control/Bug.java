package control;

import javax.swing.ImageIcon;

public class Bug extends Astro {
	
	// Constructor
	public Bug(int posicao[]) {
		this.posX = posicao[0];
		this.posY = posicao[1];
		this.icon = new ImageIcon("imgs/bugIcon.png");
	}
}
