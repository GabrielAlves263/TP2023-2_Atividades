package lab1;

public enum TipoEnumQueijo {

	MUSSARELA("1"),
	PRATO("2"),
	PARMESAO("3"),
	COALHO("4");
	
	TipoEnumQueijo(String cod) {
		this.codigo = cod;
	}
	
	public String codigo;
	
	public String getCodigo() {
		return this.codigo;
	}
}
