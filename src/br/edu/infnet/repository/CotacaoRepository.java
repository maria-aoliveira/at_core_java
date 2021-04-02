package br.edu.infnet.repository;

import java.util.ArrayList;
import br.edu.infnet.model.Cotacao;

public class CotacaoRepository extends Cotacao{
	
	private static ArrayList<Cotacao> cotacoes = new ArrayList<Cotacao>();
	private ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
	
	public CotacaoRepository(String nomeFornecedor) {
		super();
	}
	
	public void popularLista() {
		cotacoes.add(new Cotacao("Extra"));
		cotacoes.add(new Cotacao("Mundial"));
		cotacoes.add(new Cotacao("Carrefour"));
		cotacoes.add(new Cotacao("Supermarket"));
		cotacoes.add(new Cotacao("Wallmart"));
	}

	public int cadastrarCotacao(Cotacao cotacao) {
		cotacoes.add(cotacao);
		return cotacao.getId();	
	}
	
	public void listar(){
		for(Cotacao item : cotacoes) {
			System.out.println(item.getId() + " " + item.getNomeFornecedor());
		}
	}
	
	public Cotacao obterPeloId(int id) {
		for(Cotacao item : cotacoes) {
			if(item.getId() == id) {
				System.out.println(item.getId() + " " + item.getNomeFornecedor());
				return item;
			}
		}
		
		return null;
	}
	
	public void excluirPeloId(int id) {
		for(Cotacao item : cotacoes) {
			if(item.getId() == id) {
				cotacoes.remove(item);
				break;
			}
		}
	}
	
	public int buscarPeloNome(String nome) {
		Cotacao cotacao = null;
		if(cotacoes != null && cotacoes.size() > 0) {
			for(Cotacao item: cotacoes) {
				if(item.getNomeFornecedor().equals(nome)) {
					cotacao = item;
					break;
				}
			}
		}
		
		if(cotacao != null) {
			return cotacao.getId();
		}else {
			var idCotacao = cadastrarCotacao(new Cotacao(nome));
			return idCotacao;
		}
	}
	
	public void alterarCotacao(String nomeFornecedor, int idCotacao) {
		for(Cotacao item : cotacoes) {
			if(item.getId() == idCotacao) {
				item.setNomeFornecedor(nomeFornecedor);
			}
		}
	}
}
