package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PainelBotoes extends JPanel {
	
	private static final Color BOTAO_BACKGROUND = Color.CYAN;
	
	// Botoes
	public Botao btProcessar;
	public Botao btLerArquivo;
	public Botao btGravarRelatorio;
	public Botao btLerDados;
	public Botao btGravarArquivo;
	
	public PainelBotoes() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setOpaque(false);
		
		addBotoes();
		setVisible(true);
	}
	
	private void addBotoes() {
		
		add(Box.createRigidArea(new Dimension(0,10)));
		btProcessar = new Botao("<html><center>Processar próximo instante</center>", BOTAO_BACKGROUND);
		btProcessar.setEnabled(false);
		add(btProcessar);
		
		add(Box.createRigidArea(new Dimension(0,10)));
		btLerArquivo = new Botao("<html><center>Ler novo arquivo de entrada</center>", BOTAO_BACKGROUND);
		add(btLerArquivo);
		
		add(Box.createRigidArea(new Dimension(0,10)));
		btGravarRelatorio = new Botao("<html><center>Gravar relatorio</center>", BOTAO_BACKGROUND);
		btGravarRelatorio.setEnabled(false);
		add(btGravarRelatorio);
		
		add(Box.createRigidArea(new Dimension(0,10)));
		btLerDados = new Botao("<html><center>Ler dados de outros Participantes</center>", BOTAO_BACKGROUND);
		add(btLerDados);
		
		add(Box.createRigidArea(new Dimension(0,10)));
		btGravarArquivo = new Botao("<html><center>Gravar arquivo de saida</center>", BOTAO_BACKGROUND);
		btGravarArquivo.setEnabled(false);
		add(btGravarArquivo);
	}
}
