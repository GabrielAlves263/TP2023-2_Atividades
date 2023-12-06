package back;

public enum IngredienteExtra {
	
	MAIONESE("maionese"),
	KETCHUP("ketchup"),
	OVO("ovo"),
	BATATA_PALHA("batata palha");
	
	private String tipo;
	
	private IngredienteExtra(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
