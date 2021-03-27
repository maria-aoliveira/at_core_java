package br.edu.infnet.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import br.edu.infnet.model.Produto;
import br.edu.infnet.repository.ProdutoRepository;
import br.edu.infnet.service.CotacaoService;
import br.edu.infnet.service.ProdutoService;

public class Cadastro {

	public void menuCadastrar() throws ParseException {
		ProdutoRepository produtoRepository = new ProdutoRepository(null, null);

		boolean repete = true;
		int opcao = 0;
		Integer id; 
		Scanner sc = new Scanner(System.in);
		ProdutoService produtoService = new ProdutoService();
		CotacaoService cotacaoService = new CotacaoService();
		
		produtoRepository.PopularLista();

//		produtoRepository.listarPorData("27/03/2021");

		do {
			try {
				System.out.println("##################### Por favor, escolha uma das opções abaixo #####################");
				System.out.println("Opção 1 - Cadastrar Produtos");
				System.out.println("Opção 2 - Excluir Produtos");
				System.out.println("Opção 3 - Editar Produtos");
				System.out.println("Opção 4 - Consultar Produto Específico");
				System.out.println("Opção 5 - Cadastrar Cotações");
				System.out.println("Opção 6 - Consultar Cotações por Produto");
				System.out.println("Opção 7 - Imprimir na Tela os Produtos Cotados de uma Determinada Cotação");
				System.out.println("Opção 0 - Sair do programa");
				System.out.println("_________________________");
				System.out.print("Digite aqui sua opção: ");
				opcao = Integer.parseInt(sc.nextLine());

				switch (opcao) {

				case 1:
					String nome = "";
					do {
						System.out.println("Nome do produto: ");
						nome = sc.nextLine();
						
 						if(nome.isEmpty() || nome.length() < 3) {
							System.out.println("Insira um nome com pelo menos 3 letras");
						}else {
							repete = false;
						}
					}while (repete);
					
					produtoRepository.cadastrarProduto(new Produto(nome, produtoRepository.converte()));

					break;

				case 2:
					
					try {
						System.out.println("Insira o id do Produto que deseja excluir: ");
						id = sc.nextInt();
						produtoRepository.excluirProduto(id);
						
					}catch (Exception e) {
						System.out.println(e);
					}
					
					break;

				case 3:
					String data; 
					try {
						System.out.println("Insira o id do Produto que deseja editar: ");
						id = sc.nextInt();
						produtoRepository.obterId(id);
						
						System.out.println("Insira o novo nome: ");
						nome = sc.nextLine();
						
						System.out.println("Insira a nova data dd/mm/yyyy: ");
						data = sc.nextLine();
						
						produtoRepository.alterarProduto(new Produto(nome, data), id);			
					}catch (Exception e) {
						System.out.println(e);
					}
					
					break;

				case 4:
					
					break;

				default:
					System.out.println("Opção inválida");
					menuCadastrar();
				}

			} catch (Exception e) {
				System.out.println("Erro: Insira um valor válido " + e);
			} finally {
				System.out.println("Operação Finalizada" + "\n");
				menuCadastrar();
			}
		} while (opcao != 0);
		sc.close();
	}
}