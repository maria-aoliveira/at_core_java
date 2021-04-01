package br.edu.infnet.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import br.edu.infnet.errors.IndexError;
import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Produto;
import br.edu.infnet.model.ProdutoCotacao;
import br.edu.infnet.repository.CotacaoRepository;
import br.edu.infnet.repository.ProdutoCotacaoRepository;
import br.edu.infnet.repository.ProdutoRepository;
import br.edu.infnet.service.CotacaoService;
import br.edu.infnet.service.ProdutoService;

public class Cadastro {
	
	public void menuCadastrar() throws ParseException, IndexError {
		ProdutoService produtoService = new ProdutoService();
		CotacaoService cotacaoService = new CotacaoService();
		ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
		CotacaoRepository cotacaoRepository = new CotacaoRepository(null);
		ProdutoCotacaoRepository produtoCotacaoRepository = new ProdutoCotacaoRepository();
		
		produtoRepository.PopularLista();
		cotacaoRepository.popularLista();
		produtoCotacaoRepository.popularLista();
//		cotacaoRepository.buscarPeloNome("Extra");
//		produtoCotacaoRepository.listar();
////		produtoCotacaoRepository.cadastrarProdutoCotacao(new ProdutoCotacao(3, 3, 3f));
////		produtoCotacaoRepository.listar();
		
		boolean repete = true;
		Integer id; 
		String nome = "";
		String data; 
		int opcao = 0;
		Scanner sc = new Scanner(System.in);
		
//		bemVindo(sc);
			
		do {
			try {
				
				System.out.println("Opção 1 - Cadastrar Produtos");
				System.out.println("Opção 2 - Excluir Produtos");
				System.out.println("Opção 3 - Editar Produtos");
				System.out.println("Opção 4 - Consultar Produto Específico");
				System.out.println("Opção 5 - Consultar Produto por Datas");
				System.out.println("Opção 6 - Cadastrar Fornecedores");
				System.out.println("Opção 7 - Cadastrar Cotações");
				System.out.println("Opção 8 - Consultar Cotações por Produto");
				System.out.println("Opção 9 - Imprimir na Tela os Produtos Cotados de uma Determinada Cotação");
				System.out.println("Opção 0 - Sair do programa");
				System.out.println("_________________________");
				System.out.print("Digite aqui sua opção: ");
				opcao = Integer.parseInt(sc.nextLine());

				switch (opcao) {

				case 1:
					do {
						System.out.println("Nome do produto: ");
						nome = sc.nextLine();
						
 						if(nome.isEmpty() || nome.length() < 3) {
							System.out.println("Insira um nome com pelo menos três caracteres!");
						}else {
							repete = false;
							produtoRepository.cadastrarProduto(new Produto(nome, produtoRepository.converte()));
							produtoRepository.listar();
						}
					}while (repete);

					break;

				case 2:
					
					try {
						System.out.println("Insira o id do Produto que deseja excluir: ");
						id = Integer.parseInt(sc.nextLine());
						produtoRepository.excluirProduto(id);
						
					}catch (Exception e) {
						System.out.println(e);
					}
					break;

				case 3:
					
					try {
						System.out.println("Insira o id do Produto que deseja editar: ");
						id = Integer.parseInt(sc.nextLine());
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
					
					try {
						System.out.println("Insira o id do produto: ");
					id = Integer.parseInt(sc.nextLine());
					produtoRepository.obterId(id);
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
					
				case 5:
					
					try {
						System.out.println("Insira a Data (formato: dd/mm/yyyy): ");
						data = sc.nextLine();
						produtoRepository.listarPorData(data);
					}catch(Exception e) {
						System.out.println(e);
					}
					
					break;
					
				case 6:
					do {
						System.out.println("Nome do Fornecedor: ");
						nome = sc.nextLine();
						
 						if(nome.isEmpty() || nome.length() < 3) {
							System.out.println("Insira um nome com pelo menos três caracteres!");
						}else {
							repete = false;
							cotacaoRepository.cadastrarCotacao(new Cotacao(nome));
							cotacaoRepository.listar();
						}
					}while (repete);
										
					break;	
					
				case 7:
					produtoRepository.listar();
					System.out.println("Insira o id do produto: ");
					Integer idProduto = Integer.parseInt(sc.nextLine());
					
					cotacaoRepository.listar();
					System.out.println("Insira o id do fornecedor: ");
					Integer idFornecedor = Integer.parseInt(sc.nextLine());
					
					System.out.println("Preço: ");
					Float preco = Float.parseFloat(sc.nextLine());
					
					produtoCotacaoRepository.cadastrarProdutoCotacao(new ProdutoCotacao(idProduto, idFornecedor, preco));
					produtoCotacaoRepository.listar();		
					
					break;	
					
				case 8:
					
					
					break;	

				default:
					System.out.println("Opção inválida");
					menuCadastrar();
				}

			} catch (Exception e) {
				System.out.println("Erro: Insira um valor válido " + e);
				
			} finally {
				System.out.println("Operação Finalizada" + "\n");
			}
		} while (opcao != 0);
		sc.close();
	}
	
	public void bemVindo(Scanner sc){
		System.out.println("Informe seu nome: ");
		StringBuilder sb = new StringBuilder();
		String[] nomeUser = sc.nextLine().split(" ");
		sb.append("Bem-vindo, ");
		sb.append(nomeUser[0]);
		sb.append("! ");
		sb.append("Por favor, escolha uma das opções abaixo");
		System.out.println(sb.toString().trim());	

	}
}