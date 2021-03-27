package br.edu.infnet.model;

public class Cotacao {

	private int id;
	private String nomeFornecedor;
	private Float preco;
	private int id_Produto;
		
	public Cotacao() {
		super();
	}

	public Cotacao(int id, String nomeFornecedor, Float preco, int id_Produto) {
		super();
		this.id = id;
		this.nomeFornecedor = nomeFornecedor;
		this.preco = preco;
		this.id_Produto = id_Produto;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public int getId_Produto() {
		return this.id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Float getPreco() {
		return this.preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
