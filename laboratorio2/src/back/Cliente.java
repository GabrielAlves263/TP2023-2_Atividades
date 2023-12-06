package back;

public class Cliente {
	public String nome;
	public String matricula;
	
	public Cliente(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public String verificarDados(String nome, String matricula) {
		if(nome.isBlank()) {
			return "Nome do cliente está vazio";
		}
		else if(matricula.length() < 6) {
			return "Matricula invalida";
		}
		return null;
	}
}