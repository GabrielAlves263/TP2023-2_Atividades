package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo extends BufferedReader {
	
	private String nome;
	private ArrayList<String> dados;
	private int index = 1;

	public Arquivo(FileReader fr, String nome) {
		
		super(fr);
		this.nome = nome;
		this.dados = new ArrayList<String>();
		ler();
	}
	
	public void ler() {
		try {
			while(this.ready()) {
				this.dados.add(this.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] lerLinha() {
		if(naoFinalizou()) {
			index++;
			return dados.get(index-1).split(",");
		}
		else {
			return null;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean naoFinalizou() {
		if(index < dados.size()) {
			return true;
		}
		else {			
			return false;
		}
	}
}
