package br.edu.infnet.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import br.edu.infnet.errors.Custom;
import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Produto;
import br.edu.infnet.model.ProdutoCotacao;
import br.edu.infnet.repository.CotacaoRepository;
import br.edu.infnet.repository.ProdutoCotacaoRepository;
import br.edu.infnet.repository.ProdutoRepository;

public class Cadastro {
	
	public void menuCadastrar() throws Exception {

		ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
		CotacaoRepository cotacaoRepository = new CotacaoRepository(null);
		ProdutoCotacaoRepository produtoCotacaoRepository = new ProdutoCotacaoRepository();
		 
		produtoRepository.PopularLista();
		cotacaoRepository.popularLista();
		produtoCotacaoRepository.popularLista();

		boolean repete = true;
		Integer id; 
		String nome = "";
		String data; 
		int opcao = 0;
		Scanner sc = new Scanner(System.in);
		
		bemVindo(sc);
			
		do {
			try {
				
				System.out.println("Opção 1 - Cadastrar Produtos");
				System.out.println("Opção 2 - Listar os Produtos Cadastrados");
				System.out.println("Opção 3 - Excluir Produtos");
				System.out.println("Opção 4 - Editar Produtos");
				System.out.println("Opção 5 - Consultar Produto por Id");
				System.out.println("Opção 6 - Consultar Produto por Datas");
				System.out.println("Opção 7 - Cadastrar Fornecedores");
				System.out.println("Opção 8 - Cadastrar Cotações");
				System.out.println("Opção 9 - Consultar Cotação por Produto");
				System.out.println("Opção 10 - Consultar Cotação por Fornecedor");
				System.out.println("Opção 11 - Excluir Cotação por Id");
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
					produtoRepository.listar();
		        	break; 

				case 3:
					try {
						System.out.println("Insira o id do Produto que deseja excluir: ");
						id = Integer.parseInt(sc.nextLine());
						produtoRepository.excluirProduto(id);
						
					}catch (Exception e) {
						System.out.println(e);
					}
					break;
			
				case 4:
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
		
				case 5:
					try {
						System.out.println("Insira o id do produto: ");
					id = Integer.parseInt(sc.nextLine());
					produtoRepository.obterId(id);
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
					
					
				case 6:
					try {
						System.out.println("Insira a Data (formato: dd/mm/yyyy): ");
						data = sc.nextLine();
						produtoRepository.listarPorData(data);
					}catch(Exception e) {
						System.out.println(e);
					}
					
					break;
					
				case 7:
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
				case 8: 
					System.out.println("Insira o nome do produto: ");
		        	nome = sc.nextLine();
		        	Integer idProduto = produtoRepository.buscarPorNome(nome);
		        	
		        	System.out.println("Insira o fornecedor: ");
		        	String nomeFornecedor = sc.nextLine();
		        	Integer idCotacao = cotacaoRepository.buscarPeloNome(nomeFornecedor);
		        	
		        	System.out.println("Insira o preço do produto: ");
		        	float preco = Float.parseFloat(sc.nextLine());
		        	
		        	produtoCotacaoRepository.cadastrarProdutoCotacao(new ProdutoCotacao(idProduto, idCotacao, preco));
		        	produtoCotacaoRepository.listar();
		        	
		        	break;	
		        	
				case 9:
		        	System.out.println("Insira o nome do produto: ");
		        	nome = sc.nextLine();
		        	idProduto = produtoRepository.buscarPorNome(nome);		        
		        	
		        	produtoCotacaoRepository.obterProdutoId(idProduto);
		        	
		        	break;
		        	
		        case 10:
		        	System.out.println("Insira o fornecedor: ");
		        	nome = sc.nextLine();
		        	idCotacao = cotacaoRepository.buscarPeloNome(nome);       
		        	
		        	produtoCotacaoRepository.obterCotacaoId(idCotacao);
		        	break;
		        	
		        case 11:
		        	produtoCotacaoRepository.listar();
		        	
		        	System.out.println("Insira um id: ");
		        	int idProdutoCotacao = Integer.parseInt(sc.nextLine());      
		        	
		        	produtoCotacaoRepository.excluirId(idProdutoCotacao);
		        	produtoCotacaoRepository.listar();
		        	break;
					
				case 0:
					return;

				default:
					System.out.println("Opção inválida");
				}

			} catch (Exception e) {
				System.out.println("Erro: Insira um valor válido " + e);
			} finally {
				System.out.println("Operação Finalizada" + "\n");
			}
		} while (opcao != 0);
		sc.close();
	}
	
	public void bemVindo(Scanner sc) throws Custom{
		try {
			System.out.println("Informe seu nome: ");
			StringBuilder sb = new StringBuilder();
			String[] nomeUser = sc.nextLine().split(" ");
			sb.append("Bem-vindo, ");
			sb.append(nomeUser[0]);
			sb.append("! ");
			sb.append("Por favor, escolha uma das opções abaixo");
			System.out.println(sb.toString().trim());
		}catch(Exception e) {
			throw new Custom("Um erro aconteceu");
		}

	}
}