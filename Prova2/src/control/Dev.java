package control;

import javax.swing.ImageIcon;

public class Dev extends Astro {
	
	// Constructor
	public Dev(int[] posicao) {
		this.posX = posicao[0];
		this.posY = posicao[1];
		this.icon = new ImageIcon("imgs/devIcon.png");
	}
}
