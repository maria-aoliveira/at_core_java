package br.edu.infnet.repository;

import java.util.ArrayList;

import br.edu.infnet.errors.IndexError;
import br.edu.infnet.model.ProdutoCotacao;

public class ProdutoCotacaoRepository {
	private ArrayList<ProdutoCotacao> produtosCotacoes = new ArrayList<ProdutoCotacao>();
	private ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
	private CotacaoRepository cotacaoRepository = new CotacaoRepository(null);
	
	public void popularLista() {
		produtosCotacoes.add(new ProdutoCotacao(4, 2, 5.5f));
		produtosCotacoes.add(new ProdutoCotacao(2, 1, 6.7f));
		produtosCotacoes.add(new ProdutoCotacao(6, 3, 6.7f));
		produtosCotacoes.add(new ProdutoCotacao(4, 1, 6.7f));
	}
	
	public void cadastrarProdutoCotacao(ProdutoCotacao produtoCotacao) {
		produtosCotacoes.add(produtoCotacao);
	}
	
	public void listar() throws IndexError {
		for(var item : produtosCotacoes) {
			var produto = produtoRepository.obterId(item.getId_produto());
			var cotacao = cotacaoRepository.obterPeloId(item.getId_cotacao());
			
			System.out.println("Id: " + item.getIdProdutoCotacao());
			System.out.println("Nome do produto: " + produto.getNome());
			System.out.println("Data: " + produto.getData());
			System.out.println("Nome do fornecedor: " + cotacao.getNomeFornecedor());
			System.out.println("Preço do produto: " + item.getPreco());
			System.out.println("---------------------------------------");
		
		}
	}
	
	public void obterCotacaoId(int idCotacao) throws IndexError {
		for(var item : produtosCotacoes) {
			if (item.getId_cotacao()==idCotacao) {
				var produto = produtoRepository.obterId(item.getId_produto());
				var cotacao = cotacaoRepository.obterPeloId(item.getId_cotacao());
				
				System.out.println("Nome do produto: " + produto.getNome());
				System.out.println("Data: " + produto.getData());
				System.out.println("Nome do fornecedor: " + cotacao.getNomeFornecedor());
				System.out.println("Preço do produto: " + item.getPreco());
				System.out.println("");
			}
		}
	}
	
	public void excluirId(int id) {
		for (ProdutoCotacao item : produtosCotacoes) {
			if(item.getIdProdutoCotacao() == id) {
				produtosCotacoes.remove(item);
				break;
			}
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
