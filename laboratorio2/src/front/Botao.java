package front;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Botao extends JButton{

	public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setFont(new Font("arial", Font.BOLD, 20));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
