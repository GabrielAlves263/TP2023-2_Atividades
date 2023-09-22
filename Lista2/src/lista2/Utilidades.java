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

	public int kMaiorValor(int[] vet, int k) {
		// faz uma copia do vetor e a deixa em ordem crescente
		int[] newVet = copiaDeVetor(vet);
		ordenacaoCrescente(newVet);

		// retorna o k-ésimo maior valor do vetor;
		return (newVet[newVet.length-k]);
	}

	public int kMenorValor(int vet[], int k) {
		// faz uma copia do vetor e a deixa em ordem crescente
		int[] newVet = copiaDeVetor(vet);
		ordenacaoCrescente(newVet);

		//retorna o k-ésimo menor valor do vetor
		return (newVet[k-1]);
	}

	public boolean verificacaoDeIgualdade(int[] vet1, int[] vet2) {
		// verifica se os vetores possuem o mesmo tamanho
		if(vet1.length != vet2.length) {
			return false;
		}
		else {
			for(int i = 0; i < vet1.length; i++) {
				// Verifica se todos os elementos dos vetores são iguais
				if(vet1[i] != vet2[i]) {
					return false;
				}
			}
			return true;
		}
	}

	public float potenciacao(int b, int e) {
		// procedimento para expoente nulo
		if(e == 0) {
			return 1;
		}

		// procedimento para expoente positivo
		if(e > 0) {
			int pot = b;
			for(int i = 2; i <= e; i++) {
				pot *= b;
			}
			return pot;
		}

		// procedimento para expoente negativo
		else {
			float pot = (1.0f/b);
			for(int i = 2; i <= -e; i++) {
				pot *= (1.0f/b);
			}
			return pot;
		}

	}

	public boolean primo(int n) {
		if(n <= 1) {
			return true;
		}
		for(int m = 2; m*m <= n; m++) {
			if(n%m == 0) {
				return false;
			}
		}
		return true;
	}

	public int[] buscarOcorencias(int[] vet1, int[] vet2) {
		// verifica a quantidade de ocorrências
		int quant = 0;
		boolean encontrou;
		for(int i = 0; i < vet1.length; i++) {
			encontrou = false;
			for(int j = 0; j < vet2.length; j++) {
				if(vet1[i] == vet2[j] && !encontrou) {
					quant++;
					encontrou = true;
				}
			}
		}

		int[] vetOcorrencias = new int[quant];
		int pos = 0;
		boolean trocarPos;

		// Preenche o novo vetor com as ocorrencias
		for(int i = 0; i < vet1.length; i++) {
			trocarPos = false;
			for(int j = 0; j < vet2.length; j++) {
				if(vet1[i] == vet2[j]) {
					vetOcorrencias[pos] = vet2[j];
					trocarPos = true;
				}
			}
			if (trocarPos) {
				pos++;
			}
		}

		return vetOcorrencias;
	}

	public int[] removerElemento(int[] vet, int elemento) {
		// Verifica a quantidade de ocorrêcias do elemento
		int quant = vet.length;
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] == elemento) {
				quant--;
			}
		}

		// Cria e preenche o novo vetor sem o elemento
		int[] vetResult = new int[quant];
		int pos = 0;

		for(int i = 0; i < vet.length; i++) {
			if(vet[i] != elemento) {
				vetResult[pos] = vet[i];
				pos++;
			}
		}

		return vetResult;
	}

	public boolean palindromo(String str) {
		String reverseStr = inverterString(str);

		return str.equalsIgnoreCase(reverseStr);
	}

	public String inverterString(String str) {
		char[] charArray = str.toCharArray();
		int tam = charArray.length - 1;

		for (int i = 0; i <= tam; i++) {
			charArray[tam - i] = str.charAt(i);
		}

		String reverseStr = new String(charArray);

		return reverseStr;
	}

	public double jurosCompostos(double valorInicial, double taxa, int periodos) {
		double valorFinal = valorInicial;
		for(int t = 1; t <= periodos; t++) {
			valorFinal *= (1.0f + taxa);
		}

		return valorFinal;
	}

	public boolean verificarNumeroPerfeito(int n) {
		int soma = 0;

		for(int i = 1; i < n; i++) {
			if(n % i == 0) {
				soma += i;
			}
		}

		return (soma == n);
	}

	public int[] diminuirVetor(int n) {
		int[] vet = new int[n];
		int pos = 0;

		for(int i = n; i >= 1; i--) {
			vet[pos++] = i;
		}

		return vet;
	}

	public void imprimirElementosA(int tam) {

		for(int i = 0; i < tam; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(j + "\t");
			}
			System.out.println("\n");
		}
	}

	public void imprimirElementosB(int tam) {
		char[] chars = {'@', '*'};
		int pos;

		for(int i = 0; i < tam; i++) {
			for(int j = 0; j < tam; j++) {
				/* Se i e j são pares imprime '@'
				 * Se i é par e j impar imprime '*'
				 * Se i é j são impares imprime '@'
				 * Se i é impar e j é par imprime '*'
				 */
				pos = ((i % 2) == (j % 2)) ? 0 : 1;
				System.out.print(chars[pos] + "\t");
			}
			System.out.println("\n");
		}
	}

	public void imprimirElementosC(int tam) {

		// para tamanho impar
		if(tam % 2 == 1) {
			int meio = (tam / 2);

			for(int i = 0; i < tam; i++) {
				for(int j = 0; j < tam; j++) {
					if(i == meio || j == meio) {
						System.out.print('@' + "\t");
					}
					else if(i % 2 == 1) {
						System.out.print(j + "\t");
					}
					else {
						System.out.print((tam - (j + 1)) + "\t");
					}
				}
				System.out.println("\n");
			}
		}
		// para tamanho par
		else {
			int meio1 = (tam / 2);
			int meio2 = meio1 - 1;

			for(int i = 0; i < tam; i++) {
				for(int j = 0; j < tam; j++) {
					if(i == meio1 || i == meio2 || j == meio1 || j == meio2) {
						System.out.print('@' + "\t");
					}
					else if(i % 2 == 1) {
						System.out.print(j + "\t");
					}
					else {
						System.out.print((tam - (j + 1)) + "\t");
					}
				}
				System.out.println("\n");
			}
		}
	}

	public void imprimirElementosD(int tam) {
		for(int i = 0; i < tam; i++) {
			for(int j = 0; j < tam; j++) {
				// Verifica se o caractere será impresso nas linhas ou colunas das extremidades
				if(i != 0 && i != tam - 1 && j != 0 && j != tam - 1) {
					System.out.print("*" + "\t");
				}
				else {
					if(i == 0) {
						System.out.print(j + "\t");
					}
					else if (i == tam - 1) {
						System.out.print((tam - (j + 1)) + "\t");
					}
					else if(j == 0) {
						System.out.print(i + "\t");
					}
					else {
						System.out.print((tam - (i + 1)) + "\t");
					}
				}
			}
			System.out.println("\n");
		}
	}

	public void imprimirElementosE(int tam) {
		// Para tamanhos impares
		if(tam % 2 == 1) {
			int meio = tam / 2;
			for(int i = 0; i < tam; i++) {
				for(int j = 0; j < tam; j++) {
					if(j == meio) {
						System.out.print("||" + "\t");
					}
					else if(i == meio) {
						System.out.print("=" + "\t");
					}
					else if(i < meio && j < meio) {
						System.out.print("#" + "\t");
					}
					else if(i < meio) {
						System.out.print("!" + "\t");
					}
					else if(i > meio && j < meio) {
						System.out.print("*" + "\t");
					}
					else {
						System.out.print("%" + "\t");
					}
				}
				System.out.println("\n");
			}
		}
		// Para tamanhos pares
		else {
			int meio1 = (tam / 2) - 1;
			int meio2 = meio1 + 1;
			for(int i = 0; i < tam; i++) {
				for(int j = 0; j < tam; j++) {
					if(j == meio1 || j == meio2) {
						System.out.print("||" + "\t");
					}
					else if(i == meio1 || i == meio2) {
						System.out.print("=" + "\t");
					}
					else if(i < meio1 && j < meio1) {
						System.out.print("#" + "\t");
					}
					else if(i < meio1) {
						System.out.print("!" + "\t");
					}
					else if(i > meio1 && j < meio1) {
						System.out.print("*" + "\t");
					}
					else {
						System.out.print("%" + "\t");
					}
				}
				System.out.println("\n");
			}
		}
	}
	
	public void imprimirElementosF(int tam) {
		for(int i = 0; i < tam; i++) {
			for(int j = 0; j < tam; j++) {
				if(i == j) {
					System.out.print(i + "\t");
				}
				else if(i == (tam - (j + 1))) {
					System.out.print((tam - (i + 1)) + "\t");
				}
				else {
					System.out.print("*" + "\t");
				}
			}
			System.out.println("\n");
		}
	}
}
