package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String host;
	private String usuario;
	private String senha;
	private String banco;
	
	public Conexao() {
		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
	}
	
	public Connection getConexao() {
		
		String url = "jdbc:mysql://" + this.host + ":3306/" + this.banco + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			System.out.println("A conexão falhou!");
			e.printStackTrace();
		}
		return null;
	}
}
