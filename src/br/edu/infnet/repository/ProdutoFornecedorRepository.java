package br.edu.infnet.repository;

import java.util.ArrayList;

import br.edu.infnet.errors.Custom;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.Produto;
import br.edu.infnet.model.ProdutoCotacao;

public class ProdutoFornecedorRepository {
	private ArrayList<ProdutoCotacao> produtosCotacoes = new ArrayList<ProdutoCotacao>();
	private ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
	private FornecedorRepository fornecedorRepository = new FornecedorRepository(null);
	
	public void popularLista() {
		produtosCotacoes.add(new ProdutoCotacao(4, 2, 5.5f));
		produtosCotacoes.add(new ProdutoCotacao(2, 1, 6.7f));
		produtosCotacoes.add(new ProdutoCotacao(1, 3, 6.7f));
		produtosCotacoes.add(new ProdutoCotacao(4, 1, 6.7f));
		produtosCotacoes.add(new ProdutoCotacao(3, 1, 6.7f));
	}
	
	public void cadastrarProdutoCotacao(ProdutoCotacao produtoCotacao) {
		produtosCotacoes.add(produtoCotacao);
		listar();
	}
	
	public void listar(){
		for(ProdutoCotacao item : produtosCotacoes) {
			Produto produto = produtoRepository.obterId(item.getId_produto());
			Fornecedor fornecedor = fornecedorRepository.obterPeloId(item.getId_cotacao());
			
			System.out.println("Id: " + item.getIdProdutoCotacao());
			System.out.println("Nome do produto: " + produto.getNome());
			System.out.println("Data: " + produto.getData());
			System.out.println("Nome do fornecedor: " + fornecedor.getNomeFornecedor());
			System.out.println("Preço do produto: R$" + String.format("%.2f", item.getPreco()));
			System.out.println("---------------------------------------");	
		}
	}
	
	public void obterCotacaoId(int idCotacao){
		for(ProdutoCotacao item : produtosCotacoes) {
			if (item.getId_cotacao()==idCotacao) {
				Produto produto = produtoRepository.obterId(item.getId_produto());
				Fornecedor fornecedor = fornecedorRepository.obterPeloId(item.getId_cotacao());
				System.out.println("");
				System.out.println("Nome do produto: " + produto.getNome());
				System.out.println("Data: " + produto.getData());
				System.out.println("Nome do fornecedor: " + fornecedor.getNomeFornecedor());
				System.out.println("Preço do produto: R$ " + String.format("%.2f", item.getPreco()));
				System.out.println("");
			}
		}
	}
	
	public void obterProdutoId(int idProduto){
		for(ProdutoCotacao item : produtosCotacoes) {
			if(item.getId_produto() == idProduto) {
				Produto produto = produtoRepository.obterId(item.getId_produto());
				Fornecedor fornecedor = fornecedorRepository.printarPeloId(item.getId_cotacao());
				
				System.out.println("Nome do produto: " + produto.getNome());
				System.out.println("Data: " + produto.getData());
				System.out.println("Nome do fornecedor: " + fornecedor.getNomeFornecedor());
				System.out.println("Preço do produto: R$ " + String.format("%.2f", item.getPreco()));
				System.out.println("");
			}
		}
	}
		
	public void excluirId(int id) {
		boolean result = true;
		for (ProdutoCotacao item : produtosCotacoes) {
			if(item.getIdProdutoCotacao() == id) {
				produtosCotacoes.remove(item);
				result = true;
				listar();
				break;
			}else {
				result = false;
			}
		}		
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}
	}
	
	public void alterarId(int id, float preco) {
		for(ProdutoCotacao item : produtosCotacoes) {
			if(item.getIdProdutoCotacao()==id) {
				item.setPreco(preco);
				break;
			}
		}
	}
}
