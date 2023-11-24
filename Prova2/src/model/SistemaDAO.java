package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.Planeta;
import control.Sistema;

public class SistemaDAO {

	public void inserir(Sistema sistema) {

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into javalar "
					+ "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, "
					+ "bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c,"
					+ "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			inserir.setString(1, "Gabriel Alves");
			inserir.setString(2, "554870");
			inserir.setString(3, sistema.getArquivo().getNome());
			
			for(int i = 1; i <= 7; i++) {
				inserir.setInt(i + 3, sistema.getPlanetaById(i).getColisoesBugs());
				inserir.setInt(i + 10, sistema.getPlanetaById(i).getColisoesDevs());
				inserir.setInt(i + 17, (int) sistema.getPlanetaById(i).getVelocidadeMedia());
				inserir.setInt(i + 24, (int) sistema.getPlanetaById(i).getHorasPassadas());
				inserir.setInt(i + 31, sistema.getPlanetaById(i).getAnosPassados());
			}
			
			inserir.setInt(39, sistema.getDetector().getQuadrante1(sistema.getBugs()));
			inserir.setInt(40, sistema.getDetector().getQuadrante2(sistema.getBugs()));
			inserir.setInt(41, sistema.getDetector().getQuadrante3(sistema.getBugs()));
			inserir.setInt(42, sistema.getDetector().getQuadrante4(sistema.getBugs()));
			
			inserir.setInt(43, sistema.getDetector().getQuadrante1(sistema.getDevs()));
			inserir.setInt(44, sistema.getDetector().getQuadrante2(sistema.getDevs()));
			inserir.setInt(45, sistema.getDetector().getQuadrante3(sistema.getDevs()));
			inserir.setInt(46, sistema.getDetector().getQuadrante4(sistema.getDevs()));
			
			inserir.executeUpdate();
			System.out.println("Inserido");
			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selecionarTodos() {
		
		ArrayList<Planeta> planetas = new ArrayList<Planeta>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			
			String query = "";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();
			
			while(dados.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
