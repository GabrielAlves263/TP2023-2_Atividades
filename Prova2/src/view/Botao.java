package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;

public class Botao extends JButton {
	
	public Botao(String texto, Color cor) {
		super(texto);
		setBackground(cor);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setAlignmentX(CENTER_ALIGNMENT);
		setMaximumSize(new Dimension(200, 100));
	}
}
