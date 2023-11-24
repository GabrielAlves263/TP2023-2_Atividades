package control;

import java.util.ArrayList;

public class Detector {

	// Detecta colisões com Bugs
	public ArrayList<Bug> detectarColisoesBugs(Sistema sistema) {
		ArrayList<Bug> bugsToRemove = new ArrayList<Bug>();
		
		for(Planeta planeta : sistema.getPlanetas()) {
			for(Bug bug : sistema.getBugs()) {
				if(planeta.getPosX() == bug.getPosX() && planeta.getPosY() == bug.getPosY()) {
					planeta.colidir(bug);
					bugsToRemove.add(bug);
				}
			}			
		}
		
		return bugsToRemove;
	}
	
	public ArrayList<Dev> detectarColisoesDevs(Sistema sistema) {
		ArrayList<Dev> devsToRemove = new ArrayList<Dev>();
		
		for(Planeta planeta : sistema.getPlanetas()) {
			for(Dev dev : sistema.getDevs()) {
				if(planeta.getPosX() == dev.getPosX() && planeta.getPosY() == dev.getPosY()) {
					planeta.colidir(dev);
					devsToRemove.add(dev);
				}
			}	
		}
		
		return devsToRemove;
	}
	
	// Detecta explosoes
	public ArrayList<Planeta> detectarExplosoes(Sistema sistema) {
		ArrayList<Planeta> planetasExplodidos = new ArrayList<Planeta>();
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getVelocidadeTranslacao() <= 0) {
				planetasExplodidos.add(planeta);
			}
		}
		
		return planetasExplodidos;
	}
	
	// Alinhamento vertical superior
	public boolean detectarAlinhamentoInicial(Sistema sistema) {
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() != planeta.posInicial[0] || planeta.getPosY() != planeta.posInicial[1]) {
				return false;
			}
		}
		return true;
	}
	
	// Alinhamento vertical inferior
	public boolean detectarAlinhamentoVertical(Sistema sistema) {
			
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() == planeta.posInicial[0] || planeta.getPosY() != planeta.posInicial[1]) {
				return false;
			}
		}
		return true;
	}
	
	// Alinhamento diagonal superior esquerdo
	public boolean detectarAlinhamentoDSE(Sistema sistema) {
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() != planeta.limiteMaxX || planeta.getPosY() != planeta.limiteMin) { 
				return false;
			}
		}
		return true;
	}
	
	// Alinhamento diagonal superior direito
	public boolean detectarAlinhamentoDSD(Sistema sistema) {
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() != planeta.limiteMaxX || planeta.getPosY() != planeta.limiteMaxY) {
				return false;
			}
		}
		return true;
	}
	
	// Alinhamento diagonal inferior esquerdo
	public boolean detectarAlinhamentoDIE(Sistema sistema) {
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() != planeta.limiteMin || planeta.getPosY() != planeta.limiteMin) {
				return false;
			}
		}
		return true;
	}
	
	// Alinhamento diagonal inferior direito
	public boolean detectarAlinhamentoDID(Sistema sistema) {
		
		for(Planeta planeta : sistema.getPlanetas()) {
			if(planeta.getPosX() != planeta.limiteMin || planeta.getPosY() != planeta.limiteMaxX) {
				return false;
			}
		}
		return true;
	}
	
	public boolean detectarAlinhamentos(Sistema sistema) {
		return(detectarAlinhamentoInicial(sistema) || detectarAlinhamentoVertical(sistema) ||
				detectarAlinhamentoDID(sistema) || detectarAlinhamentoDIE(sistema) ||
				detectarAlinhamentoDSD(sistema) || detectarAlinhamentoDSE(sistema));
	}
	
	// Detecção de quadrantes
	
	public int getQuadrante1(ArrayList<? extends Astro> astros) {
		
		int count = 0;
		
		for(Astro astro : astros) {
			if(astro.getPosX() >= 8 && astro.getPosY() <= 8) {
				count++;
			}
		}
		
		return count;
	}

	public int getQuadrante2(ArrayList<? extends Astro> astros) {
		
		int count = 0;
		
		for(Astro astro : astros) {
			if(astro.getPosX() >= 8 && astro.getPosY() >= 9) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getQuadrante3(ArrayList<? extends Astro> astros) {
		
		int count = 0;
		
		for(Astro astro : astros) {
			if(astro.getPosX() <= 7 && astro.getPosY() <= 7) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getQuadrante4(ArrayList<? extends Astro> astros) {
		
		int count = 0;
		
		for(Astro astro : astros) {
			if(astro.getPosX() <= 7 && astro.getPosY() >= 8) {
				count++;
			}
		}
		
		return count;
	}
}
