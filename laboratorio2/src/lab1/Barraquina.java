package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Barraquina {

	private Queijo2 data = new Queijo2();

	public Barraquina() {
		System.out.println("Bem vindo a barraquinha de tecnicas!\n\n");
		data.dados = new Scanner(System.in);
		data.listaVenda = new ArrayList<Venda>();
		menuOperacoes();
	}

	private void menuOperacoes() {

		int op = 0;
		Aluno comprador = null;
		CachorroQuente cachorroQuenteEscolhido = null;
		Venda venda = null;

		do {
			op = itensDoMenu();
			switch (op) {
			case 1:
				comprador = criarAluno();
				venda = new Venda(comprador);
				break;
			case 2:

				TipoEnumQueijo tipoQueijo = escolherTipoQueijo();
				cachorroQuenteEscolhido = escolherCachorroQuente(tipoQueijo);
				venda.realizarVenda(cachorroQuenteEscolhido);

				data.listaVenda.add(venda);
				break;

			default:
				break;
			}

		} while (op != -1);
		System.out.println("Bye!");

	}

	public Aluno criarAluno() {
		Aluno comprador;
		System.out.print("\n Nome: ");
		String nome = data.dados.next();
		System.out.print("\n matricula:");
		int matricula = data.dados.nextInt();
		comprador = new Aluno(nome, matricula);
		return comprador;
	}

	private int itensDoMenu() {
		System.out.println("Escolha uma opção para registra a venda ou digite -1 para sair!");
		System.out.println("1: informar os dados do aluno comprador");
		System.out.println("2: Escolher cachorro quente");
		return data.dados.nextInt();
	}

	private TipoEnumQueijo escolherTipoQueijo() {
		String queijo = null;
		
		System.out.println("Escolha a opcao de queijo: [MUSSARELA, PRATO, PARMESSAO , COALHO]");
		queijo = data.dados.next();
		TipoEnumQueijo tipoQueijo =TipoEnumQueijo.valueOf(queijo);
		return tipoQueijo;
	}

	private CachorroQuente escolherCachorroQuente(TipoEnumQueijo tipoQueijo) {
		System.out.println("\n Escolha a opcaode cachorro quente: [1 - Salsicha, 2 - Linguica, 3 - Frango, 4- Bacon]");
		String tipo= data.dados.next();
		CachorroQuente c = null;
		switch (tipo) {
		case "1":
			c = new Salsicha(tipoQueijo);
			break;
		case "2":
			c = new Linguica(tipoQueijo);
			break;
		case "3":
			c = new Frango(tipoQueijo);
			break;
		case "4":
			c = new Bacon(tipoQueijo);
			break;

		default:
			break;
		}
		return c;
	}

}
