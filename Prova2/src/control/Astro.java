package control;

import javax.swing.ImageIcon;

public abstract class Astro implements IPosicionavel{
	protected int posX;
	protected int posY;
	
	// Icon
	protected ImageIcon icon;
	
	/* Limites do Plano e das rotas dos planetas
	 * O limite min é o mesmo para X e Y*/
	protected int limiteMin;
	protected int limiteMaxX;
	protected int limiteMaxY;
	
	// Getters
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
}
