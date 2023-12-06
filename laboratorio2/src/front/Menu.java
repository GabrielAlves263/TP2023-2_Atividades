package front;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel{
	
	public Menu(JanelaPrincipal janelaPrincipal) {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		BotaoRealizarVendas botaoRealizarVendas = new BotaoRealizarVendas("Realizar Venda", Color.GREEN);
		botaoRealizarVendas.addActionListener(janelaPrincipal);
		add(botaoRealizarVendas);
		add(new BotaoListarVendas("Listar Vendas", Color.GREEN));
		add(new BotaoMostrarRelatorio("Mostrar Relatório", Color.GREEN));
		add(new BotaoListarClientes("Listar Clientes", Color.GREEN));
		
	}
}
