package br.edu.infnet.repository;

import java.util.Arrays;
import java.util.List;
import br.edu.infnet.model.Cotacao;

public class CotacaoRepository {
	
	private static Cotacao[] cotacao = {
			new Cotacao(1, "Extra", 5.00f, 1),
			new Cotacao(2, "Mundial", 6.00f, 2),
			new Cotacao(3, "Carrefour", 8.00f, 3),
			new Cotacao(4, "Supermarket", 15.00f, 4),
			new Cotacao(5, "Wallmart", 35.00f, 5),
	};
	
	public List<Cotacao> listar(){
		return Arrays.asList(cotacao);
	}
	
	public Cotacao obterId(int id) {
		return cotacao[id];
		
	}
	
}
