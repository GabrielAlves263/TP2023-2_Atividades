package control;

import java.util.ArrayList;

import model.SistemaDAO;

public class Sistema {
	// Astros do sistema
	private ArrayList<Planeta> planetas;
	private ArrayList<Planeta> explodidos;
	private ArrayList<Bug> bugs;
	private ArrayList<Dev> devs;
	
	// Arquivo
	private Arquivo arquivo;
	
	// DAO
	private SistemaDAO sistemaDAO;
	
	// Detector
	private Detector detector;
	
	// Atributos
	private int instantes = 0;
	
	// Constructor
	public Sistema(int a) {
		System.out.println("Ola, seja bem-vindo ao Sistema JavaLar!");

		gerarArrayLists();
		gerarPlanetas();
		
		// Menu principal
		new Menu(this);
		new Relatorio(this);
		
		System.out.println("\nSaindo do Sistema JavaLar... volte sempre!");
	}
	
	public Sistema() {
		gerarArrayLists();
		gerarPlanetas();
		this.sistemaDAO = new SistemaDAO();
		this.detector = new Detector();
	}

	private void gerarArrayLists() {
		this.planetas = new ArrayList<Planeta>();
		this.explodidos = new ArrayList<Planeta>();
		this.bugs = new ArrayList<Bug>();
		this.devs = new ArrayList<Dev>();
	}

	private void gerarPlanetas() {
		addPlaneta(new Python("Python"));
		addPlaneta(new JavaScript("JavaScript"));
		addPlaneta(new Ruby("Ruby"));
		addPlaneta(new Php("PHP"));
		addPlaneta(new CSharp("Csharp"));
		addPlaneta(new Cpp("Cpp"));
		addPlaneta(new C("C"));
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
	
	public Planeta getPlanetaById(int id) {
		for(Planeta planeta : planetas) {
			if(planeta.getId() == id) {
				return planeta;
			}
		}
		
		for(Planeta planeta : explodidos) {
			if(planeta.getId() == id) {
				return planeta;
			}
		}
		
		return null;
	}
	
	public Detector getDetector() {
		return detector;
	}
	
	public ArrayList<Bug> getBugs() {
		return this.bugs;
	}
	
	public ArrayList<Dev> getDevs() {
		return devs;
	} 
	
	public int getInstantes() {
		return this.instantes;
	}
	
	public ArrayList<Planeta> getPlanetasNorte() {
		ArrayList<Planeta> planetasNorte = new ArrayList<Planeta>();
		
		for(Planeta planeta : planetas) {			
			if(planeta.posX >= 8) {
				planetasNorte.add(planeta);
			}
		}
		
		return planetasNorte;
	}
	
	public ArrayList<Planeta> getPlanetasSul() {
		ArrayList<Planeta> planetasSul = new ArrayList<Planeta>();
		
		for(Planeta planeta : planetas) {			
			if(planeta.posX < 8) {
				planetasSul.add(planeta);
			}
		}
		
		return planetasSul;
	}
	
	public Arquivo getArquivo() {
		return arquivo;
	}
	
	// Adders
	
	public void addPlaneta(Planeta planeta) {
		this.planetas.add(planeta);
	}
	
	public void addBugs(int quantBugs) {
		Gerador gerador = new Gerador();
		
		for(int i = 1; i <= quantBugs; i++) {		
			if(!isFull()) {
				this.bugs.add(new Bug(gerador.gerarPosicao(this)));
			}
			else {
				return;
			}
		}
	}
	
	public void addDevs(int quantDevs) {
		Gerador gerador = new Gerador();
		
		for(int i = 1; i <= quantDevs; i++) {			
			if(!isFull()) {
				this.devs.add(new Dev(gerador.gerarPosicao(this)));				
			}
			else {
				return;
			}
		}
	}	
	
	public void inclementarInstantes(int tempo) {
		this.instantes += tempo;
	}
	
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
	// Roda os planetas
	public void rodar() {
		if(arquivo.naoFinalizou() ) {			
			new Rodada(this);
		}
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
	
	// Remove planetas explodidos
	public void removerExplodidos(ArrayList<Planeta> planetasExplodidos) {
		for(Planeta planeta : planetasExplodidos) {
			this.explodidos.add(planeta);
			this.planetas.remove(planeta);
		}
	}
	
	// Verifica o limite maximo de bugs e devs foi alcançado
	// Limite máximo = 17 * 16 - 6 - 7 = 259 
	public boolean isFull() {
		if((bugs.size() + devs.size()) > 259) {
			System.out.println("\nO sistema chegou ao seu limite maximo de astros!");
			return true;
		}
		return false;
	}
	
	// Enviar dados para o banco;
	public void gravarRelatorio() {
		sistemaDAO.inserir(this);
	}
}
