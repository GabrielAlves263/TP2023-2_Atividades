package front;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel {
	
	private JLabel label;

	public Display() {
		this.setBackground(Color.white);
		label = new JLabel("Realizar Venda");
		add(label);
	}
}