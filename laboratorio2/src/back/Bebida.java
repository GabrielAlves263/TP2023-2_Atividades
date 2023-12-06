package back;

public enum Bebida {

	COCA_COLA("coca-cola"),
	DEL_RIO("del-rio"),
	SUCO_DO_CHAVES("suco do chaves");
	
	private String tipo;
	
	Bebida(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
