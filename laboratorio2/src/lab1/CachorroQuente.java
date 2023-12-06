package lab1;

import java.util.ArrayList;

public abstract class CachorroQuente {

	protected TipoEnumQueijo queijo;
	protected ArrayList<String> ingredientes;
	protected String bebiba;
	
	public CachorroQuente(TipoEnumQueijo queijo) {
		this.queijo = queijo;		
	}
	
	public void adicionarIngredientes(String ingrediente) {
	
		ingredientes.add(ingrediente);
	}
}
