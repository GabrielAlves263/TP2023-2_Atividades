package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Planeta;

public class PainelPlano extends JPanel {
	
	ArrayList<Planeta> planetas;
	JLabel[][] celulas = new JLabel[17][18];
	
	private static final Color CELULA_FUNDO = Color.WHITE;
	private static final Color CELULA_BORDA = Color.BLACK;
	
	// Imagens
	private static final ImageIcon SPACE_ICON = new ImageIcon("imgs/spaceIcon.png");
	private static final ImageIcon JAVA_ICON = new ImageIcon("imgs/javaIcon.png");
	
	GridBagConstraints gbc;
	
	public PainelPlano(ArrayList<Planeta> planetas) {
		
		this.planetas = planetas;
		
		criarComponents();
		criarCelulas();
		removerCelulas();
		addJavaIcon();
		addPlanetas();
	}

	public void addPlanetas() {

		for(int i = 9; i < 16; i++) {			
			setLabelIcon(8, i, planetas.get(i-9).getIcon());
		}
	}
	
	public void addJavaIcon() {
		gbc.gridx = 7;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		JLabel label = new JLabel();
		label.setOpaque(false);
//		label.setBorder(new LineBorder(CELULA_BORDA));
		label.setIcon(new ImageIcon(JAVA_ICON.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH)));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, gbc);
	}

	public void removerCelulas() {
		remove(celulas[7][7]);
		remove(celulas[7][8]);
		remove(celulas[8][7]);
		remove(celulas[8][8]);
		remove(celulas[9][7]);
		remove(celulas[9][8]);
	}
	
	private void criarComponents() {
		
		setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));		
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.ipadx = 100;
		gbc.ipady = 100;
	
		gbc.fill = GridBagConstraints.BOTH;
		
		setOpaque(false);
		setLayout(new GridBagLayout());
	}

	private void criarCelulas() {
		
		for(int i = 0; i < 17; i++) {
			for(int j = 0; j < 16; j++) {				
					gbc.gridx = i;
					gbc.gridy = j;
					JLabel label = new JLabel();
					label.setOpaque(false);
//					label.setBorder(new LineBorder(CELULA_BORDA));
					label.setIcon(new ImageIcon(SPACE_ICON.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
					label.setHorizontalAlignment(JLabel.CENTER);
					
					celulas[i][15-j] = (JLabel)label; 
					add(label, gbc);
			}
		}
	}
	
	public void setLabelIcon(int y, int x, ImageIcon icon) {
		celulas[y][x].setIcon(new ImageIcon(icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
	}
}
