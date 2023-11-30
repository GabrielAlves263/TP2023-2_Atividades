package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gravador {
	
	public Gravador(String analise) {
		gravarArquivo(analise);
	}
	
	public void gravarArquivo(String analise) {
		
		try {
			File file = criarArquivo();
			
			// Limpa o Arquivo
			FileWriter fw = new FileWriter(file);
			fw.close();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write("");
			bw.flush();
			bw.write(analise);
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File criarArquivo() throws IOException {
		File file = new File("output/Relatorio.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
}
