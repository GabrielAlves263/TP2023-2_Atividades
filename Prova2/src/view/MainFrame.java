package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.Bug;
import control.Dev;
import control.Planeta;
import control.Sistema;

public class MainFrame extends JFrame {

	Sistema sistema;
	
	// Janela
	public static final String JANELA_TITULO = "JavaLar";
	public static final int JANELA_LARGURA = 900;
	public static final int JANELA_ALTURA = 700;
	public static final Color JANELA_COR_FUNDO = Color.WHITE;
	public static final Color JANELA_COR_TEXTO = Color.BLACK;
	public static final ImageIcon JANELA_ICONE = new ImageIcon("imgs/javaLarIcon.png");

	// Imagens
	private static final ImageIcon SPACE_ICON = new ImageIcon("imgs/spaceIcon.png");
	
	// Panels
	JPanel pnPrincipal;
	PainelBotoes painelBotoes;
	PainelPlano painelPlano;
	
	public MainFrame(Sistema sistema) {
		super(JANELA_TITULO);
		this.sistema = sistema;
		
		// MainFrame Configs
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(JANELA_LARGURA, JANELA_ALTURA);
		setLocationRelativeTo(null);
		setIconImage(JANELA_ICONE.getImage());
		add(new JLabel(JANELA_ICONE));
		setContentPane(criarPainelPrincipal());
		setBackground(Color.WHITE);
		
		setVisible(true);
	}

	private JPanel criarPainelPrincipal() {
		
		pnPrincipal = new JPanel(new BorderLayout());
		
		pnPrincipal.setOpaque(false);
		
		pnPrincipal.setBackground(JANELA_COR_FUNDO);
		
		painelPlano = new PainelPlano(sistema.getPlanetas());
		painelBotoes = new PainelBotoes();
		
		pnPrincipal.add(painelPlano, BorderLayout.CENTER);
		pnPrincipal.add(painelBotoes, BorderLayout.EAST);
		
		addListeners();
		
		return pnPrincipal;
	}
	
	public void addListeners() {
		painelBotoes.btProcessar.addActionListener(new ProcessarListener());
		painelBotoes.btLerArquivo.addActionListener(new LerArquivoListener());
		painelBotoes.btGravarRelatorio.addActionListener(new GravarRelatorioListener());
		painelBotoes.btLerDados.addActionListener(new LerDadosListener());
		painelBotoes.btGravarArquivo.addActionListener(new GravarArquivoListener());
	}

	// LISTENERS
	private class ProcessarListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			verificarEOF();
			
			// Atualiza as imagens de planetas, bugs e devs
			painelBotoes.btProcessar.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				
			atualizarOldPos();
			sistema.rodar();
			atualizarNewPos();

			painelBotoes.btProcessar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			verificarEOF();
		}

		public void verificarEOF() {
			if(!sistema.getArquivo().naoFinalizou()) {
				JOptionPane.showMessageDialog(null, "O arquivo chegou ao fim", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				painelBotoes.btProcessar.setEnabled(false);
				painelBotoes.btGravarRelatorio.setEnabled(true);
			}
		}

		public void atualizarNewPos() {
			for(Planeta planeta : sistema.getPlanetas()) {
				painelPlano.setLabelIcon(planeta.getPosY(), planeta.getPosX(), planeta.getIcon());
			}
			for(Bug bug : sistema.getBugs()) {
				painelPlano.setLabelIcon(bug.getPosY(), bug.getPosX(), bug.getIcon());
			}
			for(Dev dev : sistema.getDevs()) {
				painelPlano.setLabelIcon(dev.getPosY(), dev.getPosX(), dev.getIcon());
			}
		}

		public void atualizarOldPos() {
			for(Planeta planeta : sistema.getPlanetas()) {
				painelPlano.setLabelIcon(planeta.getPosY(), planeta.getPosX(), SPACE_ICON);
			}
			for(Bug bug : sistema.getBugs()) {
				painelPlano.setLabelIcon(bug.getPosY(), bug.getPosX(), SPACE_ICON);
			}
			for(Dev dev : sistema.getDevs()) {
				painelPlano.setLabelIcon(dev.getPosY(), dev.getPosX(), dev.getIcon());
			}
		}
	}
	
	private class LerArquivoListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// Janela para escolher o arquvio
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("arquivos"));
			fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));
			int returnValue = fileChooser.showOpenDialog(painelPlano.getParent());
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {

				try {
					sistema.setArquivo(fileChooser.getSelectedFile());
					painelBotoes.btProcessar.setEnabled(true);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private class GravarRelatorioListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			painelBotoes.btGravarRelatorio.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			sistema.gravarRelatorio();
			painelBotoes.btGravarRelatorio.setEnabled(false);
			painelBotoes.btGravarRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		
	}

	private class LerDadosListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			painelBotoes.btLerDados.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			sistema.lerDados();
			painelBotoes.btGravarArquivo.setEnabled(true);
			painelBotoes.btLerDados.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
	}

	private class GravarArquivoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			sistema.gravarArquivo();
			JOptionPane.showMessageDialog(null, "Relatório gravado com sucesso!", "Exito", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
