package br.edu.infnet.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import br.edu.infnet.errors.Custom;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.Produto;
import br.edu.infnet.model.ProdutoCotacao;
import br.edu.infnet.repository.FornecedorRepository;
import br.edu.infnet.repository.ProdutoFornecedorRepository;
import br.edu.infnet.repository.ProdutoRepository;

public class Cadastro {
	
	ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
	FornecedorRepository fornecedorRepository = new FornecedorRepository(null);
	ProdutoFornecedorRepository produtoFornecedorRepository = new ProdutoFornecedorRepository();
	Scanner sc = new Scanner(System.in);

	public Cadastro () throws Custom {
		produtoRepository.PopularLista();
		fornecedorRepository.popularLista();
		produtoFornecedorRepository.popularLista();
		bemVindo(sc);
	}

	public void menuCadastrar() throws Exception {

		boolean repete = true;
		Integer id; 
		String nome = "";
		String data; 
		int opcao = 0;
			
		do {
			try {
				
				System.out.println("Opção 1 - Cadastrar Produtos");
				System.out.println("Opção 2 - Listar os Produtos Cadastrados");
				System.out.println("Opção 3 - Excluir Produtos");
				System.out.println("Opção 4 - Editar Produtos");
				System.out.println("Opção 5 - Consultar Produto por Id");
				System.out.println("Opção 6 - Consultar Produto por Datas");
				System.out.println("Opção 7 - Consultar Produto por Nome");
				System.out.println("Opção 8 - Cadastrar Fornecedores");
				System.out.println("Opção 9 - Listar Fornecedores");
				System.out.println("Opção 10 - Excluir Fornecedores");
				System.out.println("Opção 11 - Editar Fornecedores");
				System.out.println("Opção 12 - Consultar Fornecedores por Id");
				System.out.println("Opção 13 - Consultar Fornecedores por Nome");			
				System.out.println("Opção 14 - Cadastrar Cotações");
				System.out.println("Opção 15 - Consultar Cotação por Produto");
				System.out.println("Opção 16 - Consultar Cotação por Fornecedor");
				System.out.println("Opção 17 - Excluir Cotação por Id");
				System.out.println("Opção 18 - Listar Cotações");
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
						var produto = produtoRepository.imprimirId(id);
						
						if(produto == null) {
							System.out.println("Tente novamente");
						}else {
							System.out.println("Insira o novo nome: ");
							nome = sc.nextLine();
							
							System.out.println("Insira a nova data dd/mm/yyyy: ");
							data = sc.nextLine();
							
							produtoRepository.alterarProduto(new Produto(nome, data), id);
						}		
					}catch (Exception e) {
						System.out.println(e);
					}
					break;
		
				case 5:
					try {
						System.out.println("Insira o id do produto: ");
						id = Integer.parseInt(sc.nextLine());
						produtoRepository.imprimirId(id);
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
					try {
						System.out.println("Digite o nome do produto que deseja buscar: ");
						nome = sc.nextLine();
						produtoRepository.imprimirPorNome(nome);
						
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
					
				case 8:
					do {
						System.out.println("Nome do Fornecedor: ");
						nome = sc.nextLine();
						
 						if(nome.isEmpty() || nome.length() < 3) {
							System.out.println("Insira um nome com pelo menos três caracteres!");
						}else {
							repete = false;
							fornecedorRepository.cadastrarFornecedor(new Fornecedor(nome));
							fornecedorRepository.listar();
						}
					}while (repete);
										
					break;	
					
				case 9:
					fornecedorRepository.listar();
					break;
					
				case 10:
					try {
						System.out.println("Insira o id do fornecedor que deseja excluir: ");
						id = Integer.parseInt(sc.nextLine());
						fornecedorRepository.excluirPeloId(id);
					} catch(Exception e) {
						System.out.println(e);
					}
					break;		
					
				case 11:
					try {
						fornecedorRepository.listar();
						System.out.println("Insira o id do Fornecedor que deseja editar: ");
						id = Integer.parseInt(sc.nextLine());
						var fornecedor = fornecedorRepository.obterPeloId(id);
						
						if(fornecedor == null) {
							System.out.println("Tente novamente");
						}else {
							System.out.println("Insira o novo nome: ");
							nome = sc.nextLine();
							
							fornecedorRepository.alterarFornecedor(nome, id);
							fornecedorRepository.listar();
						}								
					}catch (Exception e) {
						System.out.println(e);
					}
					break;
					
				case 12:
					
					try {
						System.out.println("Insira o id do fornecedor: ");
						id = Integer.parseInt(sc.nextLine());
						fornecedorRepository.printarPeloId(id);
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
					
				case 13:
					
					try {
						System.out.println("Insira o nome do fornecedor que deseja buscar: ");
						nome = sc.nextLine();
						fornecedorRepository.imprimirPeloNome(nome);
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
									
				case 14: 
					
					System.out.println("Insira o nome do produto: ");
		        	nome = sc.nextLine();
		        	Integer idProduto = produtoRepository.imprimirPorNome(nome);
		        	
		        	System.out.println("Insira o fornecedor: ");
		        	String nomeFornecedor = sc.nextLine();
		        	Integer idCotacao = fornecedorRepository.imprimirPeloNome(nomeFornecedor);
		        	
		        	float preco = 0.0f;
		    		System.out.print("Digite o valor do produto: ");
		    		String precoString = sc.nextLine();
		    		if(precoString.contains(",")) {
		    			precoString = precoString.replace(",", ".");
		    			preco = Float.parseFloat(precoString);
		    		}else {
		    			preco = Float.parseFloat(precoString);
		    		}
		        	
		        	produtoFornecedorRepository.cadastrarProdutoCotacao(new ProdutoCotacao(idProduto, idCotacao, preco));
		        	
		        	break;	
		        	
				case 15:
		        	System.out.println("Insira o nome do produto: ");
		        	nome = sc.nextLine();
		        	idProduto = produtoRepository.buscarPorNome(nome);	
		        	System.out.println("----------");
		        	System.out.println("Cotações:");
		        	produtoFornecedorRepository.obterProdutoId(idProduto);
		        	
		        	break;
		        	
		        case 16:
		        	System.out.println("Insira o fornecedor: ");
		        	nome = sc.nextLine();
		        	id = fornecedorRepository.imprimirPeloNome(nome);       
		        	
		        	produtoFornecedorRepository.obterCotacaoId(id);
		        	break;
		        	
		        case 17:
		        	produtoFornecedorRepository.listar();      	
		        	System.out.println("Insira um id: ");
		        	int idProdutoCotacao = Integer.parseInt(sc.nextLine());      		        	
		        	produtoFornecedorRepository.excluirId(idProdutoCotacao);
		        	break;
		        	
		        case 18:
		        	produtoFornecedorRepository.listar();
					break;
				case 0:
					return;

				default:
					System.out.println("Opção inválida");
				}

			}catch (NumberFormatException e) {
				System.err.println("Digite apenas números");
				menuCadastrar();
			}
			catch (Exception e) {
				System.out.println("Erro: Insira um valor válido " + e);
				menuCadastrar();
			}finally {
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