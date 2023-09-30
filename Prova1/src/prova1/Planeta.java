package prova1;

import java.util.ArrayList;

public abstract class Planeta extends Astro {
	
	protected String nome;
	protected float horasPassadas = 0;
	protected int velocidadeTranslacao;
	protected float velocidadeRotacao;
	protected float velocidadeMedia;
	protected ArrayList<Colisao> colisoesBugs = new ArrayList<Colisao>();
	protected ArrayList<Colisao> colisoesDevs = new ArrayList<Colisao>();
	
	// Constructor
	public Planeta(String nome) {
		this.nome = nome;
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
		}
	}
	
	// Rotação
	public void rotacionar(int tempo) {
		this.horasPassadas += velocidadeRotacao * tempo;
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
