package prova1;

import java.util.ArrayList;
import java.util.Random;

public class Sistema {
	// Astros do sistema
	private ArrayList<Planeta> planetas;
	private ArrayList<Planeta> explodidos;
	private ArrayList<Bug> bugs;
	private ArrayList<Dev> devs;
	
	// Atributos
	private int instantes = 0;
	
	// Constructor
	public Sistema() {
		this.planetas = new ArrayList<Planeta>();
		this.explodidos = new ArrayList<Planeta>();
		this.bugs = new ArrayList<Bug>();
		this.devs = new ArrayList<Dev>();
	}
	
	// Getters
	
	public ArrayList<Planeta> getPlanetas() {
		return this.planetas;
	}
	
	public ArrayList<Planeta> getExplodidos() {
		return this.explodidos;
	}
	
	public Planeta getPlanetaAt(int i) {
		return this.planetas.get(i);
	}
	
	public int getBugs() {
		return bugs.size();
	}
	
	public int getDevs() {
		return devs.size();
	}
	
	public int getInstantes() {
		return this.instantes;
	}
	
	// Inclementar instantes
	public void inclementarInstantes(int tempo) {
		this.instantes += tempo;
	}
	
	// Adiciona Planetas
	public void addPlaneta(Planeta planeta) {
		this.planetas.add(planeta);
	}
	
	// Adiciona Bugs
	public void addBugs(int quantBugs) {
		for(int i = 1; i <= quantBugs; i++) {		
			if(!lotado()) {				
				this.bugs.add(new Bug(gerarPosicao()));
			}
			else {
				return;
			}
		}
	}
	
	// Adiciona Devs
	public void addDevs(int quantDevs) {
		for(int i = 0; i <= quantDevs; i++) {			
			if(!lotado()) {
				this.devs.add(new Dev(gerarPosicao()));				
			}
			else {
				imprimirLotado();
				return;
			}
		}
	}
	
	// Traslada e rotaciona cada planeta
	public void rodar(int tempo) {
		for (Planeta planeta : planetas) {
			planeta.transladar(tempo);
			planeta.rotacionar(tempo);
			planeta.attVelocidadeMedia();
		}
		this.inclementarInstantes(tempo);
	}
	
	// Detecta colisões com Bugs
	public ArrayList<Bug> detectarColisoesBugs() {
		ArrayList<Bug> bugsToRemove = new ArrayList<Bug>();
		
		for(Planeta planeta : planetas) {
			for(Bug bug : bugs) {
				if(planeta.getPosX() == bug.getPosX() && planeta.getPosY() == bug.getPosY()) {
					planeta.colidir(bug);
					bugsToRemove.add(bug);
				}
			}			
		}
		
		return bugsToRemove;
	}
	
	// Detecta colisões com Devs
	public ArrayList<Dev> detectarColisoesDevs() {
		ArrayList<Dev> devsToRemove = new ArrayList<Dev>();
		
		for(Planeta planeta : planetas) {
			for(Dev dev : devs) {
				if(planeta.getPosX() == dev.getPosX() && planeta.getPosY() == dev.getPosY()) {
					planeta.colidir(dev);
					devsToRemove.add(dev);
				}
			}	
		}
		
		return devsToRemove;
	}
	
	// Remove Bugs e Devs que colidiram com planetas
	public void removerBugs(ArrayList<Bug> bugsToRemove) {
		for(Bug bug : bugsToRemove) {
			this.bugs.remove(bug);
		}
	}
	
	public void removerDevs(ArrayList<Dev> devsToRemove) {
		for(Dev dev : devsToRemove) {
			this.devs.remove(dev);
		}
	}
	
	// Detecta explosoes
	public ArrayList<Planeta> detectarExplosoes() {
		ArrayList<Planeta> planetasExplodidos = new ArrayList<Planeta>();
		
		for(Planeta planeta : planetas) {
			if(planeta.getVelocidadeTranslacao() <= 0) {
				planetasExplodidos.add(planeta);
			}
		}
		
		return planetasExplodidos;
	}
	
	// Remove planetas explodidos
	public void removerExplodidos(ArrayList<Planeta> planetasExplodidos) {
		for(Planeta planeta : planetasExplodidos) {
			this.explodidos.add(planeta);
			this.planetas.remove(planeta);
		}
	}
	
	// Gera e verifica posicoes
	public int[] gerarPosicao() {
		int[] posicao = new int[2];
		do {
			Random random = new Random();
			posicao[0] = random.nextInt(16);
			posicao[1] = random.nextInt(17);
		} while (!verificarPosicao(posicao));
		return posicao;
			
	}
	
	// Retorna verdadeiro caso não haja nenhum outro astro na posicao informada;
	public boolean verificarPosicao(int[] posicao) {
		for(Bug bug : bugs) {
			if(posicao[0] == bug.getPosX() && posicao[1] == bug.getPosY()) {
				return false;
			}
		}
		for(Dev dev : devs) {
			if(posicao[0] == dev.getPosX() && posicao[1] == dev.getPosY()) {
				return false;
			}
		}
		return true;
	}
	
	// Verifica o limite maximo de bugs e devs foi alcançado
	// Limite máximo = 17 * 16 - 6 - 7 = 259 
	public boolean lotado() {
		if((bugs.size() + devs.size()) > 259) {
			return true;
		}
		return false;
	}
	
	public void imprimirLotado() {
		System.out.println("\nO sistema chegou ao seu limite maximo de astros!");
	}

//	// Planetas no norte
//	public Planeta[] getPlanetasNorte() {
//		
//	}
//	
//	// Planetas no sul
//	public Planeta[] getPlanetasSul() {
//		
//	}
}
