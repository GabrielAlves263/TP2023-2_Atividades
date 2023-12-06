package front;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import back.Bebida;
import back.Cliente;
import back.IngredienteExtra;
import back.Proteina;
import back.Queijo;

public class JanelaRealizarVenda extends JPanel implements ActionListener {
	
	JTextField nomeCliente;
	JFormattedTextField matricula;
	JComboBox<Queijo> opcQueijo;
	JComboBox<Proteina> opcProteina;
	JComboBox<Bebida> opcBebida;
	CheckBoxes ingredientesExtra;
	
	public JanelaRealizarVenda() {
		organizador();
		adicionarComponentes();
	}
	
	private void organizador() {
		setLayout(new GridLayout(7, 2, 50, 50));
		setBounds(1, 1, 100, 100);
		setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));
		
		setVisible(true);
	}
	
	private void adicionarComponentes() {
		
		addNomeCliente();
		
		addMatricula();
		
		addOpcQueijo();
		
		addOpcProteina();
		
		addCheckBoxes();
		
		addBebida();
		
		addBotaoRealizarVenda();
		
	}

	public void addBotaoRealizarVenda() {
		add(new JLabel());
		BotaoRealizarVendas botaoRealizarVendas = new BotaoRealizarVendas("Realizar Venda", Color.blue);
		botaoRealizarVendas.addActionListener(this);
		add(botaoRealizarVendas);
	}

	public void addBebida() {
		add(new JLabel("Bebida:"));
		
		opcBebida = new JComboBox<Bebida>(Bebida.values());
		opcBebida.setSelectedIndex(-1);
		add(opcBebida);
	}

	public void addCheckBoxes() {
		add(new JLabel("Ingredientes Extra:"));
		CheckBoxes ingredienteExtra = new CheckBoxes();
		add(ingredienteExtra);
	}

	public void addOpcProteina() {
		add(new JLabel("Opção de proteína:"));
		
		opcProteina = new JComboBox<Proteina>(Proteina.values());
		opcProteina.setSelectedIndex(-1);
		add(opcProteina);
	}

	public void addOpcQueijo() {
		add(new JLabel("Opção de queijo:"));

		opcQueijo = new JComboBox<Queijo>(Queijo.values());
		opcQueijo.setSelectedIndex(-1);
		add(opcQueijo);
	}

	public void addNomeCliente() {
		add(new JLabel("Nome cliente:"));
		nomeCliente = new JTextField(4);
		add(nomeCliente);
	}

	public void addMatricula() {
		
		MaskFormatter mascaraMatricula = null;
		
		try {
			mascaraMatricula = new MaskFormatter("######");
		} catch (ParseException e) {
			System.err.println("Erro na formatacao: " + e.getMessage());
			System.exit(-1);
		}
		
		add(new JLabel("Matrícula:"));
		
		matricula = new JFormattedTextField(mascaraMatricula);
		matricula.setBounds(100,100,100,100);
		add(matricula);
	}
	
	private class CheckBoxes extends JLabel {
		
		public CheckBoxes() {
			
			setLayout(new GridLayout(2,2));
			
			addCheckBoxes();
		}
		
		private Checkbox criarCheckbox(String texto) {
			Checkbox checkbox = new Checkbox(texto);
			return checkbox;
		}
		
		private void addCheckBoxes() {
			for(IngredienteExtra ingrediente : IngredienteExtra.values()) {				
				add(criarCheckbox(ingrediente.getTipo()));
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Cliente cliente = new Cliente(nomeCliente.getText(), matricula.getText());
		String verificacao = cliente.verificarDados(cliente.getNome(), cliente.getMatricula());
		if(verificacao.isEmpty()) {	
			JOptionPane.showMessageDialog(this, verificacao, "Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}
}
