package control;

import java.util.ArrayList;
import java.util.Collections;

public class Analisador {
	
	private String analise = "";
	private ArrayList<ArrayList<String>> dados;

	public Analisador(ArrayList<ArrayList<String>> dados) {
		this.dados = dados;
		analisarDados();
	}
	
	public String getAnalise() {
		return analise;
	}
	
	public void analisarDados() {
		analise = "";
		analise = analise.concat(maisAnalisou() + ", ");
		analise = analise.concat(maisMorreu(getVelocidadesMedias()) + ", ");
		analise = analise.concat(menosMorreu(getVelocidadesMedias()) + ", ");
		analise = analise.concat(analisarQuadrantes(getBugsPorQuad())  + ", ");
		analise = analise.concat(analisarQuadrantes(getDevsPorQuad())  + ", ");
		analise = analise.concat(analisesTotais() + ", ");
		analise = analise.concat(analisarVelocidadesMedias(getVelocidadesMedias()) + ", "); 
		analise = analise.concat(totalPorQuad(getBugsPorQuad()) + ", ");
		analise = analise.concat(totalPorQuad(getDevsPorQuad()) + ", ");
		analise = analise.concat(horasTotais() + ", ");
		analise = analise.concat(anosTotais() + "");
	}
	
	// Aluno que mais analisou
	private String maisAnalisou() {
		ArrayList<String> matriculas = dados.get(1);
		
		String nomeMaior = "";
		String matricula = "";
		int maior = 0;
		int count;
		
		for(int i = 0; i < matriculas.size(); i++) {
			count = Collections.frequency(matriculas, matriculas.get(i));
			if(count > maior) {
				maior = count;
				nomeMaior = dados.get(0).get(matriculas.lastIndexOf(matriculas.get(i)));
				matricula = matriculas.get(i);
			}
			i = matriculas.lastIndexOf(matriculas.get(i));
		}
		
		return(matricula + " - " + nomeMaior);
	}

	// Planeta que mais morreu
	private String maisMorreu(float[] velocidades) {
		String[] planetas = {"Python", "JavaScript", "Ruby on Rails", "PHP", "C#", "C++", "C"};
		int iMenor = 0;
		float menor = velocidades[iMenor];
		
		for(int i = 1; i < 7; i++) {
			if(velocidades[i] < menor) {
				menor = velocidades[i];
				iMenor = i;
			}
		}
		
		return planetas[iMenor];
	}
	
	// Planeta que menos morreu
	private String menosMorreu(float[] velocidades) {
		String[] planetas = {"Python", "JavaScript", "Ruby on Rails", "PHP", "C#", "C++", "C"};
		int iMaior = 0;
		float maior = velocidades[iMaior];
		
		for(int i = 1; i < 7; i++) {
			if(velocidades[i] > maior) {
				maior = velocidades[i];
				iMaior = i;
			}
		}
		
		return planetas[iMaior];
	}
	
	// Quadrantes onde os bugs e devs se concentram
	private int[] getBugsPorQuad() {
		int[] bugsPorQuad = new int[4];
		
		for(int i = 0; i < 4; i++ ) {
			for(String valor : dados.get(38+i)) {
				if(valor != null) {					
					bugsPorQuad[i] += Integer.parseInt(valor);
				}
			}
		}
		
		return bugsPorQuad;
	}
	
	private int[] getDevsPorQuad() {
		int[] devsPorQuad = new int[4];
		
		for(int i = 0; i < 4; i++ ) {
			for(String valor : dados.get(42+i)) {
				if(valor != null) {					
					devsPorQuad[i] += Integer.parseInt(valor);
				}
			}
		}
		
		return devsPorQuad;
	}
	
	private String analisarQuadrantes(int[] quadrantes) {
		int iMaior = 0;
		int maior = quadrantes[iMaior];
		for(int i = 1; i < 4; i++) {
			if(quadrantes[i] > maior) {
				maior = quadrantes[i];
				iMaior = i;
			}
		}
		
		iMaior++;
		return iMaior + "";
	}
	
	// Total de analise
	private int analisesTotais() {
		return dados.get(0).size();
	}
	
	// Velocidade media
	private float[] getVelocidadesMedias() {
		float[] velocidades = new float[7];
		
		for(int i = 0; i < 7; i++) {
			for(String valor : dados.get(17+i)) {
				if(valor != null) {
					velocidades[i] += Integer.parseInt(valor);
				}
			}
			
			velocidades[i] /= dados.get(17+i).size(); 
		}
		
		return velocidades;
	}

	private String analisarVelocidadesMedias(float[] vels) {
		return "Python: " + vels[0] + " - JavaScript: " + vels[1]
				+ " - Ruby on Rails: " + vels[2] + " - PHP: " + vels[3]
				+ " - C#: " + vels[4] + " - C++: " + vels[5]
				+ " - C: " + vels[6];
	}
	
	// Total de bugs e devs
	private int totalPorQuad(int[] quadrantes) {
		int soma = 0;
		for(int valor : quadrantes) {
			soma += valor;
		}
		return soma;
	}
	
	// Total de horas
	private int horasTotais() {
		int horasTotais = 0;
		
		for(int i = 24; i <= 30; i++) {
			for(String valor : dados.get(i) ) {
				if(valor != null) {
					horasTotais += Integer.parseInt(valor);
				}
			}
		}
		
		return horasTotais;
	}
	
	// Total de anos
	private int anosTotais() {
		int anosTotais = 0;
		
		for(int i = 31; i <= 37; i++) {
			for(String valor : dados.get(i)) {
				if(valor != null) {
					anosTotais += Integer.parseInt(valor);
				}
			}
		}
		
		return anosTotais;
	}
}
