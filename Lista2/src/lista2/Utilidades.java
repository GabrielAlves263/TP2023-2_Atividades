package lista2;

public class Utilidades {
	
	public int somatorio(int[] vet) {
		int soma = 0;
	
		if(vet.length < 5) {
			return 0;
		}
		else {
			for(int i = 2; i <= vet.length - 3; i++) {
				soma += vet[i];
			}
			return soma;
		}
	}
	
	public void numerosPares(int nInicial, int nFinal) {
		for(int i = nInicial; i <= nFinal; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public float media(int[] vet1, int[] vet2) {
		float soma = 0;
		
		for(int i = 0; i < vet1.length; i++) {
			soma += vet1[i];
		}
		for(int i = 0; i < vet2.length; i++) {
			soma += vet2[i];
		}
		
		return (soma / (vet1.length + vet2.length));
	}
	
	public float mediaPonderada(float[] notas, int[] pesos) {
		float somaNotas = 0;
		int somaPesos = 0;
		for(int i = 0; i < notas.length; i++) {
			somaNotas += notas[i]*pesos[i];
			somaPesos += pesos[i];
		}
		
		return (somaNotas / somaPesos);
	}
	
	public int contagemDeElementos(int[] vet1, int[] vet2, int elemento) {
		int contagem = 0;
		
		for(int i = 0; i < vet1.length; i++) {
			if(vet1[i] == elemento) {
				contagem++;
			}
		}
		for(int i = 0; i < vet2.length; i++) {
			if(vet2[i] == elemento) {
				contagem++;
			}
		}
		
		return contagem;
	}
	
	public int[] copiaDeVetor(int[] vet) {
		return vet;
	}
	
	public void ordenacaoCrescente(int[] vet) {
		for(int i = 1; i < vet.length; i++) { 
			int k = vet[i];
			int j = i-1;
			while(j >= 0 && k < vet[j]) {
				vet[j+1] = vet[j];
				j--;
			}
			vet[j+1] = k;
		}
	}
	
	public boolean verificacaoDeOrdenacao(int[] vet) {
		int i = 0;
		while(i < vet.length-1) {
			if(vet[i] > vet[i+1]) {
				return false;
			}
			else {
				i++;
			}
		}
		return true;
	}
	
}
