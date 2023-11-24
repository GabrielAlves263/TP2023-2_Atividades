package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import control.Sistema;
import model.Conexao;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Connection con = new Conexao().getConexao();
//		if(con != null) {
//			System.out.println("Conectado com sucesso!");
//			System.out.println(con);
//		}
		
		
		new MainFrame(new Sistema());
	}
}
