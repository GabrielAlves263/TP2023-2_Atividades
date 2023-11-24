package control;

import java.util.Random;

	public class Gerador {
		
		public int[] gerarPosicao(Sistema sistema) {
			int[] posicao = new int[2];
			do {
				Random random = new Random();
				posicao[0] = random.nextInt(16);
				posicao[1] = random.nextInt(17);
			} while (!verificarPosicao(sistema, posicao));
			return posicao;
				
		}
		
		// Retorna verdadeiro caso não haja nenhum outro astro na posicao informada;
		public boolean verificarPosicao(Sistema sistema, int[] posicao) {
			for(Bug bug : sistema.getBugs()) {
				if(posicao[0] == bug.getPosX() && posicao[1] == bug.getPosY()) {
					return false;
				}
			}
			for(Dev dev : sistema.getDevs()) {
				if(posicao[0] == dev.getPosX() && posicao[1] == dev.getPosY()) {
					return false;
				}
			}
			return true;
		}
}
