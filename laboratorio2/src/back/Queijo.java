package back;

public enum Queijo {
	
	MUSARELLA("mussarela"),
	PRATO("prato"),
	PARMESAO("parmesao"),
	COALHO("coalho");
	
	private String tipo;
	
	Queijo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
