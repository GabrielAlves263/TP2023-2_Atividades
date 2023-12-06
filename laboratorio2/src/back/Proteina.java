package back;

public enum Proteina {
	
	SALCICHA("salcinha"),
	LINGUICA("linguica"),
	FRANGO("frango"),
	BANCO("banco");
	
	private String tipo;
	
	Proteina(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
