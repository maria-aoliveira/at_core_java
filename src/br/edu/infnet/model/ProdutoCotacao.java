package br.edu.infnet.model;

public class ProdutoCotacao {

	private int idProdutoCotacao;
	private int id_produto;
	private int id_cotacao;
	private Float preco;
	public static int nextId = 1;
	
	public ProdutoCotacao(int id_produto, int id_cotacao, Float preco) {
		this.idProdutoCotacao = ProdutoCotacao.nextId;
		ProdutoCotacao.nextId++;
		this.setId_produto(id_produto);
		this.setId_cotacao(id_cotacao);
		this.setPreco(preco);
	}
	
	public int getIdProdutoCotacao() {
		return this.idProdutoCotacao;
	}
	
	public void setIdProdutoCotacao(int idProdutoCotacao) {
		this.idProdutoCotacao = idProdutoCotacao;
	}
	
	public int getId_cotacao() {
		return this.id_cotacao;
	}
	
	public void setId_cotacao(int id_cotacao) {
		this.id_cotacao = id_cotacao;
	}
	
	public int getId_produto() {
		return this.id_produto;
	}
	
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	public Float getPreco() {
		return this.preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
