package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo extends BufferedReader {
	
	private String nome;
	
	public Arquivo(FileReader fr, String nome) throws IOException {
		
		super(fr);
		this.nome = nome;
		
		// Lê a primeira linha de cabeçalho 
		this.readLine();
	}
	
	public String[] getDados() {
		if(naoFinalizou()) {
			try {
				return readLine().split(",");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;	
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean naoFinalizou() {
		try {
			if(ready()) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
