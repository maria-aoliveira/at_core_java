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
		for(var item : cotacoes) {
			System.out.println(item.getId() + " " + item.getNomeFornecedor());
		}
	}
	
	public Cotacao obterPeloId(int id) {
		for(var item : cotacoes) {
			if(item.getId() == id) {
				System.out.println(item.getId() + " " + item.getNomeFornecedor());
				return item;
			}
		}
		
		return null;
	}
	
	public void excluirPeloId(int id) {
		for(var item : cotacoes) {
			if(item.getId() == id) {
				cotacoes.remove(item);
				break;
			}
		}
	}
	
	public int buscarPeloNome(String nome) {
		for(var item: cotacoes) {
			if(item.getNomeFornecedor().equals(nome)) {
				return item.getId();
			}
		}
		
		return 0;
	}
}
