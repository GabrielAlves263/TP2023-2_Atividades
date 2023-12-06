package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame implements ActionListener {

	Display display;
	JanelaRealizarVenda janelaRealizarVenda;
	
	public JanelaPrincipal() {
		organizador();
	}
	
	private void organizador() {
		setSize(800, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(criarPainelPrincipal());
		setVisible(true);
	}
	
	private JPanel criarPainelPrincipal() {
		JPanel pnPrincipal = new JPanel();
		Menu menu = new Menu(this);
		display = new Display();
		janelaRealizarVenda = new JanelaRealizarVenda();		
		
		pnPrincipal.setBackground(Color.white);
		
		pnPrincipal.setLayout(new BorderLayout(5,5));
		pnPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		pnPrincipal.add(menu, BorderLayout.PAGE_START);
//		pnPrincipal.add(display, BorderLayout.CENTER);
		pnPrincipal.add(janelaRealizarVenda);
		pnPrincipal.setVisible(true);
		
		return pnPrincipal;
	}
	
	public static void main(String args[]) {
		
		new JanelaPrincipal();
	}

	public void actionPerformed(ActionEvent e) {
		if(janelaRealizarVenda.isVisible()) {
			janelaRealizarVenda.setVisible(false);
		}
		else {
			janelaRealizarVenda.setVisible(true);
		}
	}
	

}
