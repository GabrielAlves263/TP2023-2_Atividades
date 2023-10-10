package prova1;

import java.util.ArrayList;
import java.lang.Math;

public abstract class Planeta extends Astro {
	
	protected String nome;
	protected int[] posInicial;
	protected float horasPassadas = 0;
	protected int anosPassados = 0;
	protected int velocidadeTranslacao;
	protected float velocidadeRotacao;
	protected float velocidadeMedia;
	protected ArrayList<Colisao> colisoesBugs;
	protected ArrayList<Colisao> colisoesDevs;
	protected String resumo;
	
	// Constructor
	public Planeta(String nome) {
		this.nome = nome;
		this.posInicial = new int[2];
		this.colisoesBugs = new ArrayList<Colisao>();
		this.colisoesDevs = new ArrayList<Colisao>();
	}
	
	// Getters
	public String getNome() {
		return nome;
	}
	
	public int getVelocidadeTranslacao() {
		return velocidadeTranslacao;
	}
	
	public float getVelocidadeRotacao() {
		return velocidadeRotacao;
	}
	
	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}
	
	public float getHorasPassadas() {
		return horasPassadas;
	}
	
	public int getAnosPassados() {
		return anosPassados;
	}
	
	public int getDistancia(Planeta planeta) {
		return ((Math.abs(this.posX - planeta.posX) + 1) * (Math.abs(this.posY - planeta.posY) + 1));
	}
	
	public double getDistanciaEuclidiana(Planeta planeta) {
		return (Math.sqrt(Math.pow(this.posX - planeta.posX, 2) + Math.pow(this.posX - planeta.posX, 2)));
	}
	
	// Seters
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	// Ganhar-Perder Velocidade
	public void ganharVelocidade() {
		this.velocidadeTranslacao++;
	}
	
	public void perderVelocidade() {
		this.velocidadeTranslacao--;
	}
	
	// Trasnlação
	public void transladar(int tempo) {
		for(int i = 1; i <= velocidadeTranslacao * tempo; i++) {
			
			// Deslocamento a partir da extremidade superior esquerda da rota
			if(posX != limiteMin && posY == limiteMin) {
				posX--;
			}
			// Deslocamento a partir da extremidade inferior esquerda da rota
			else if(posX == limiteMin && posY != limiteMaxY) {
				posY++;
			}
			// Deslocamento a partir da extremidade inferior direita da rota
			else if(posX != limiteMaxX && posY == limiteMaxY) {
				posX++;
			}
			// Deslocamento a partir da extremidade superior direita da rota
			else {
				posY--;
			}
			
			// Incrementa um ano caso necessário
			incrementarAno();
		}
	}
	
	// Rotação
	public void rotacionar(int tempo) {
		this.horasPassadas += velocidadeRotacao * tempo;
	}
	
	// Anos
	public void incrementarAno() {
		if(posX == posInicial[0] && posY == posInicial[1]) {
			this.anosPassados++;
		}
	}
	
	// Colisao
	public void colidir(Bug bug) {
		this.perderVelocidade();
		this.colisoesBugs.add(new Colisao(this, bug));
	}
	
	public void colidir(Dev dev) {
		this.ganharVelocidade();
		this.colisoesDevs.add(new Colisao(this, dev));
	}
	
	// Atualizar Valores
	public void attVelocidadeMedia() {
		this.velocidadeMedia = (velocidadeMedia + velocidadeTranslacao) / 2.0f;
	}
}
